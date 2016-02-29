package com.timepath.quakec.psi.impl

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFileFactory
import com.intellij.psi.PsiReferenceBase
import com.timepath.quakec.ide.file.QCFileType
import com.timepath.quakec.ide.reference.QCReference
import com.timepath.quakec.psi.*
import kotlin.jvm.JvmStatic as static

object QCPsiImplUtil {

    fun createFile(project: Project, text: String): QCFile {
        val name = "dummy.qc"
        return PsiFileFactory.getInstance(project).createFileFromText(name, QCFileType, text) as QCFile
    }

    fun <T> create(project: Project, newName: String): T {
        return createFile(project, newName).firstChild as T
    }

    fun createIdentifier(project: Project, s: String): PsiElement {
        val variable = create<QCVariableDeclaration>(project, "void $s;")
        return variable.variableList[0].nameIdentifier
    }

    @static fun getName(element: QCIdentifier): String = element.nameIdentifier.text

    @static fun setName(element: QCIdentifier, newName: String): QCIdentifier {
        element.replace(createIdentifier(element.project, newName))
        return element
    }

    @static fun getReference(self: QCIdentifier): PsiReferenceBase<PsiElement>? = QCReference.create(self)

    @static fun getName(element: QCTypedef): String = element.nameIdentifier.text

    @static fun setName(element: QCTypedef, newName: String): PsiElement {
        element.nameIdentifier.replace(createIdentifier(element.project, newName))
        return element
    }

    @static fun getName(element: QCParameter): String? = element.nameIdentifier?.text

    @static fun setName(element: QCParameter, newName: String): PsiElement {
        element.nameIdentifier?.replace(createIdentifier(element.project, newName))
        return element
    }

    @static fun getName(element: QCVariable): String = element.nameIdentifier.text

    @static fun setName(element: QCVariable, newName: String): PsiElement {
        element.nameIdentifier.replace(createIdentifier(element.project, newName))
        return element
    }

    @static fun getName(element: QCMethod): String = element.nameIdentifier.text

    @static fun setName(element: QCMethod, newName: String): PsiElement {
        element.nameIdentifier.replace(createIdentifier(element.project, newName))
        return element
    }

}
