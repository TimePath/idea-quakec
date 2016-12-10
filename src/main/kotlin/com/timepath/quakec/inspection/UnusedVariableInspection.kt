package com.timepath.quakec.inspection

import com.intellij.codeHighlighting.HighlightDisplayLevel
import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.ProblemHighlightType
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElementVisitor
import com.timepath.quakec.ide.reference.QCReference
import com.timepath.quakec.psi.QCVariable
import com.timepath.quakec.psi.QCVisitor

class UnusedVariableInspection : LocalInspectionTool() {

    override fun getDefaultLevel() = HighlightDisplayLevel.WARNING!!

    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return object : QCVisitor() {
            override fun visitVariable(o: QCVariable) {
                super.visitVariable(o)
                val id = o.nameIdentifier
                val psiReferenceBase = QCReference.create(id)
                if (psiReferenceBase != null && psiReferenceBase.resolve() == null)
                    holder.registerProblem(id, "Unused variable", ProblemHighlightType.GENERIC_ERROR_OR_WARNING)
            }
        }
    }

}
