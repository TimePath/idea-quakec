package com.timepath.quakec.ide;

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
import com.timepath.quakec.psi.QCIdentifier;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.List;

/**
 * @author TimePath
 */
public class QCReference extends PsiReferenceBase<PsiElement> implements PsiPolyVariantReference {

    private String key;

    public QCReference(@NotNull PsiElement element, TextRange textRange) {
        super(element, textRange);
        key = element.getText().substring(textRange.getStartOffset(), textRange.getEndOffset());
    }

    private void findAll(GlobalSearchScope scope, Processor<QCIdentifier> processor) {
        Project project = getElement().getProject();
        PsiManager psiManager = PsiManager.getInstance(project);
        FileBasedIndex fileBasedIndex = FileBasedIndex.getInstance();
        Collection<VirtualFile> files = fileBasedIndex
                .getContainingFiles(FileTypeIndex.NAME, QCFileType.INSTANCE, scope);
        for (VirtualFile v : files) {
            PsiFile file = psiManager.findFile(v);
            if (!findFile(file, processor)) break;
        }
    }

    /**
     *
     * @param containingFile
     * @param processor
     * @return true if processor is still accepting
     */
    private boolean findFile(final PsiFile containingFile, Processor<QCIdentifier> processor) {
        List<QCIdentifier> identifiers = CachedValuesManager.getCachedValue(
                containingFile, new CachedValueProvider<List<QCIdentifier>>() {
                    @Nullable
                    @Override
                    public Result<List<QCIdentifier>> compute() {
                        return CachedValueProvider.Result.create(computeDefinitions(QCIdentifier.class), containingFile);
                    }

                    public <T> List<T> computeDefinitions(final Class<T> clazz) {
                        final List<T> result = ContainerUtil.newArrayList();
                        containingFile.acceptChildren(new PsiRecursiveElementWalkingVisitor() {
                            @SuppressWarnings("unchecked")
                            @Override
                            public void visitElement(PsiElement element) {
                                if (clazz.isInstance(element)) {
                                    result.add((T) element);
                                }
                                super.visitElement(element);
                            }
                        });
                        return result;
                    }
                });
        return ContainerUtil.process(identifiers, processor);
    }

    @NotNull
    @Override
    public ResolveResult[] multiResolve(boolean incompleteCode) {
        QCIdentifier[] elements = getVariants();
        ResolveResult[] results = new ResolveResult[elements.length];
        for (int i = 0; i < results.length; i++) {
            results[i] = new PsiElementResolveResult(elements[i]);
        }
        return results;
    }

    @Nullable
    @Override
    public PsiElement resolve() {
        FindProcessor<QCIdentifier> processor = new FindProcessor<QCIdentifier>() {
            @Override
            protected boolean accept(QCIdentifier o) {
                return Comparing.equal(o.getName(), key);
            }
        };
        findAll(GlobalSearchScope.projectScope(getElement().getProject()), processor);
        return processor.getFoundValue();
    }

    @NotNull
    @Override
    public QCIdentifier[] getVariants() {
        CollectProcessor<QCIdentifier> processor = new CollectProcessor<QCIdentifier>();
        findAll(GlobalSearchScope.projectScope(getElement().getProject()), processor);
        return ArrayUtil.toObjectArray(processor.getResults(), QCIdentifier.class);
    }

}
