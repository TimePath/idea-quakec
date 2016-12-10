package com.timepath.quakec.psi.impl

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFileFactory
import com.timepath.quakec.ide.file.QCFileType
import com.timepath.quakec.ide.reference.QCReference
import com.timepath.quakec.psi.*
import kotlin.jvm.JvmStatic as static

object QCPsiImplUtil {

    fun createFile(project: Project, text: String): QCFile {
        val name = "dummy.qc"
        return PsiFileFactory.getInstance(project).createFileFromText(name, QCFileType, text) as QCFile
    }

    @Suppress("UNCHECKED_CAST")
    fun <T> create(project: Project, newName: String) = createFile(project, newName).firstChild as T

    fun createIdentifier(element: PsiElement, newName: String): PsiElement {
        val variable = create<QCVariableDeclaration>(element.project, "void $newName;")
        return variable.variableList[0].nameIdentifier
    }

    public @static fun getName(element: QCIdentifier) = element.nameIdentifier.text!!

    public @static fun setName(element: QCIdentifier, newName: String): PsiElement {
        element.replace(createIdentifier(element, newName))
        return element
    }

    public @static fun getReference(self: QCIdentifier) = QCReference.create(self)

    public @static fun getName(element: QCTypedef) = element.nameIdentifier.text!!

    public @static fun setName(element: QCTypedef, newName: String): PsiElement {
        element.nameIdentifier.replace(createIdentifier(element, newName))
        return element
    }

    public @static fun getName(element: QCParameter) = element.nameIdentifier?.text

    public @static fun setName(element: QCParameter, newName: String): PsiElement {
        element.nameIdentifier?.replace(createIdentifier(element, newName))
        return element
    }

    public @static fun getName(element: QCVariable) = element.nameIdentifier.text!!

    public @static fun setName(element: QCVariable, newName: String): PsiElement {
        element.nameIdentifier.replace(createIdentifier(element, newName))
        return element
    }

    public @static fun getName(element: QCMethod) = element.nameIdentifier.text!!

    public @static fun setName(element: QCMethod, newName: String): PsiElement {
        element.nameIdentifier.replace(createIdentifier(element, newName))
        return element
    }

}
