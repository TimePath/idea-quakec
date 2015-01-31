package com.timepath.quakec.inspection;

import com.intellij.codeHighlighting.HighlightDisplayLevel;
import com.intellij.codeInspection.LocalInspectionTool;
import com.intellij.codeInspection.ProblemHighlightType;
import com.intellij.codeInspection.ProblemsHolder;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiReferenceBase;
import com.timepath.quakec.ide.reference.QCReference;
import com.timepath.quakec.psi.QCIdentifier;
import com.timepath.quakec.psi.QCVariable;
import com.timepath.quakec.psi.QCVisitor;
import org.jetbrains.annotations.NotNull;

/**
 * @author TimePath
 */
public class UnusedVariableInspection extends LocalInspectionTool {

    @NotNull
    @Override
    public HighlightDisplayLevel getDefaultLevel() {
        return HighlightDisplayLevel.WARNING;
    }

    @NotNull
    @Override
    public PsiElementVisitor buildVisitor(@NotNull final ProblemsHolder holder, boolean isOnTheFly) {
        return new QCVisitor() {
            @Override
            public void visitVariable(@NotNull QCVariable o) {
                super.visitVariable(o);
                QCIdentifier id = o.getNameIdentifier();
                PsiReferenceBase<? extends PsiElement> psiReferenceBase = QCReference.create(id);
                if (psiReferenceBase != null && psiReferenceBase.resolve() == null)
                    holder.registerProblem(id, "Unused variable", ProblemHighlightType.GENERIC_ERROR_OR_WARNING);
            }
        };
    }

}