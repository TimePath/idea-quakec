package com.timepath.quakec;

import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import com.timepath.quakec.psi.QCIdentifier;
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
        final List<QCIdentifier> idents = QCUtil.findIdentifiers(project, key);
        List<ResolveResult> results = new ArrayList<ResolveResult>();
        for (QCIdentifier id : idents) {
            results.add(new PsiElementResolveResult(id));
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
        List<QCIdentifier> idents = QCUtil.findIdentifiers(project, null);
        List<LookupElement> variants = new ArrayList<LookupElement>();
        for (final QCIdentifier id : idents) {
            if (id.getText() != null && id.getText().length() > 0) {
                variants.add(LookupElementBuilder.create(id).
                                withIcon(QCIcons.FILE).
                                withTypeText(id.getContainingFile().getName())
                );
            }
        }
        return variants.toArray();
    }
}
