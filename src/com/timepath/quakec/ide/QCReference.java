package com.timepath.quakec.ide;

import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import com.timepath.quakec.icons.QCIcons;
import com.timepath.quakec.psi.QCNamedElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
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

    @NotNull
    @Override
    public ResolveResult[] multiResolve(boolean incompleteCode) {
        Project project = myElement.getProject();
        final List<QCNamedElement> elements = QCUtil.find(project, key, QCNamedElement.class);
        List<ResolveResult> results = new ArrayList<ResolveResult>();
        for (QCNamedElement named : elements) {
            results.add(new PsiElementResolveResult(named));
        }
        return results.toArray(new ResolveResult[results.size()]);
    }

    @Nullable
    @Override
    public PsiElement resolve() {
        ResolveResult[] resolveResults = multiResolve(false);
        return resolveResults.length == 1 ? resolveResults[0].getElement() : null;
    }

    @NotNull
    @Override
    public Object[] getVariants() {
        Project project = myElement.getProject();
        List<QCNamedElement> elements = QCUtil.find(project, null, QCNamedElement.class);
        List<LookupElement> variants = new ArrayList<LookupElement>();
        for (final QCNamedElement named : elements) {
            if (named.getName() != null && named.getName().length() > 0) {
                variants.add(LookupElementBuilder.create(named).
                                withIcon(QCIcons.FILE).
                                withTypeText(named.getContainingFile().getName())
                );
            }
        }
        return variants.toArray();
    }
}
