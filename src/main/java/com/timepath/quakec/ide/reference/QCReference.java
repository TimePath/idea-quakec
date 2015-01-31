package com.timepath.quakec.ide.reference;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Comparing;
import com.intellij.openapi.util.TextRange;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.*;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.CachedValueProvider;
import com.intellij.psi.util.CachedValuesManager;
import com.intellij.util.ArrayUtil;
import com.intellij.util.CommonProcessors.CollectProcessor;
import com.intellij.util.CommonProcessors.FindProcessor;
import com.intellij.util.Processor;
import com.intellij.util.containers.ContainerUtil;
import com.intellij.util.indexing.FileBasedIndex;
import com.timepath.quakec.ide.file.QCFileType;
import com.timepath.quakec.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.List;

/**
 * @author TimePath
 */
public class QCReference extends PsiReferenceBase<PsiElement> implements PsiPolyVariantReference {

    public static PsiReferenceBase<? extends PsiElement> create(@NotNull QCIdentifier identifier) {
        if (isDeclaration(identifier)) {
            return null;
        }
        return new QCReference(identifier);
    }

    private String key;

    private QCReference(@NotNull PsiElement element) {
        super(element, TextRange.allOf(element.getText()));
        key = element.getText();
    }

    private static boolean isDeclaration(@NotNull QCIdentifier identifier) {
        PsiElement parent = identifier.getParent();
        return parent instanceof QCMethod
                || parent instanceof QCParameter
                || parent instanceof QCVariable;
    }

    private boolean isScopeElement(@NotNull PsiElement element) {
        return isBlockElement(element)
                || element instanceof QCMethod
                || element instanceof QCFile;
    }

    private boolean isBlockElement(PsiElement element) {
        return element instanceof QCBlock
                || element instanceof QCBlockSwitch;
    }

    private List<PsiElement> getScopes() {
        List<PsiElement> scopes = ContainerUtil.newLinkedList();
        PsiElement e = getElement();
        while ((e = e.getParent()) != null) {
            if (isScopeElement(e)) {
                scopes.add(e);
            }
        }
        Project project = getElement().getProject();
        PsiManager psiManager = PsiManager.getInstance(project);
        FileBasedIndex fileBasedIndex = FileBasedIndex.getInstance();
        Collection<VirtualFile> files = fileBasedIndex
                .getContainingFiles(FileTypeIndex.NAME, QCFileType.INSTANCE, GlobalSearchScope.projectScope(project));
        for (VirtualFile v : files) {
            scopes.add(psiManager.findFile(v));
        }
        return scopes;
    }

    private void find(Processor<QCIdentifier> processor) {
        List<PsiElement> scopes = getScopes();
        List<QCIdentifier> all = ContainerUtil.newArrayList();
        for (PsiElement scope : scopes) {
            List<QCIdentifier> identifiers = findScope(scope);
            all.addAll(identifiers);
            if (!ContainerUtil.process(identifiers, processor)) {
                // No longer processing
                break;
            }
        }
    }

    private List<QCIdentifier> findScope(final PsiElement parent) {
        return CachedValuesManager.getCachedValue(parent, new CachedValueProvider<List<QCIdentifier>>() {
            @Nullable
            @Override
            public Result<List<QCIdentifier>> compute() {
                return Result.create(computeImpl(), parent);
            }

            private List<QCIdentifier> computeImpl() {
                final List<QCIdentifier> result = ContainerUtil.newArrayList();
                parent.acceptChildren(new PsiElementVisitor() {
                    @Override
                    public void visitElement(PsiElement element) {
                        super.visitElement(element);
                        if (element instanceof QCIdentifier) {
                            QCIdentifier identifier = (QCIdentifier) element;
                            if (isDeclaration(identifier)) {
                                result.add(identifier);
                            }
                        }
                        if (!isBlockElement(element)) {
                            element.acceptChildren(this);
                        }
                    }
                });
                return result;
            }
        });
    }

    @NotNull
    @Override
    public ResolveResult[] multiResolve(boolean incompleteCode) {
        QCIdentifier[] elements = resolveAll();
        ResolveResult[] results = new ResolveResult[elements.length];
        for (int i = 0; i < results.length; i++) {
            results[i] = new PsiElementResolveResult(elements[i]);
        }
        return results;
    }

    private QCIdentifier[] resolveAll() {
        CollectProcessor<QCIdentifier> processor = new CollectProcessor<>();
        find(processor);
        return ArrayUtil.toObjectArray(processor.getResults(), QCIdentifier.class);
    }

    @Nullable
    @Override
    public PsiElement resolve() {
        FindProcessor<QCIdentifier> processor = new FindProcessor<QCIdentifier>() {
            @Override
            protected boolean accept(QCIdentifier o) {
                if (o == null) return false;
                String name = o.getName();
                final boolean[] isVector = {false};
                o.getParent().accept(new QCVisitor() {
                    @Override
                    public void visitType(@NotNull QCType o) {
                        isVector[0] = "vector".equals(o.getText());
                    }

                    @Override
                    public void visitParameter(@NotNull QCParameter o) {
                        o.getType().accept(this);
                    }

                    @Override
                    public void visitVariable(@NotNull QCVariable o) {
                        o.getParent().accept(this);
                    }

                    @Override
                    public void visitVariableDeclaration(@NotNull QCVariableDeclaration o) {
                        o.getType().accept(this);
                    }
                });
                boolean isComponent = Comparing.equal(name + "_x", key) ||
                        Comparing.equal(name + "_y", key) ||
                        Comparing.equal(name + "_z", key);
                return Comparing.equal(name, key) || (isVector[0] && isComponent);
            }
        };
        find(processor);
        return processor.getFoundValue();
    }

    @NotNull
    @Override
    public QCIdentifier[] getVariants() {
        return resolveAll();
    }

}
