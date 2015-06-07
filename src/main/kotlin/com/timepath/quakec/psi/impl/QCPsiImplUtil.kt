package com.timepath.quakec.psi.impl

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFileFactory
import com.intellij.psi.PsiReferenceBase
import com.timepath.quakec.ide.file.QCFileType
import com.timepath.quakec.ide.reference.QCReference
import com.timepath.quakec.psi.*
import kotlin.platform.platformStatic as static

public object QCPsiImplUtil {

    fun createFile(project: Project, text: String): QCFile {
        val name = "dummy.qc"
        return PsiFileFactory.getInstance(project).createFileFromText(name, QCFileType, text) as QCFile
    }

    fun <T> create(project: Project, newName: String): T {
        return createFile(project, newName).getFirstChild() as T
    }

    fun createIdentifier(project: Project, s: String): PsiElement {
        val variable = create<QCVariableDeclaration>(project, "void $s;")
        return variable.getVariableList()[0].getNameIdentifier()
    }

    public static fun getName(element: QCIdentifier): String = element.getNameIdentifier().getText()

    public static fun setName(element: QCIdentifier, newName: String): QCIdentifier {
        element.replace(createIdentifier(element.getProject(), newName))
        return element
    }

    public static fun getReference(self: QCIdentifier): PsiReferenceBase<PsiElement>? = QCReference.create(self)

    public static fun getName(element: QCTypedef): String = element.getNameIdentifier().getText()

    public static fun setName(element: QCTypedef, newName: String): PsiElement {
        element.getNameIdentifier().replace(createIdentifier(element.getProject(), newName))
        return element
    }

    public static fun getName(element: QCParameter): String? = element.getNameIdentifier()?.getText()

    public static fun setName(element: QCParameter, newName: String): PsiElement {
        element.getNameIdentifier()?.replace(createIdentifier(element.getProject(), newName))
        return element
    }

    public static fun getName(element: QCVariable): String = element.getNameIdentifier().getText()

    public static fun setName(element: QCVariable, newName: String): PsiElement {
        element.getNameIdentifier().replace(createIdentifier(element.getProject(), newName))
        return element
    }

    public static fun getName(element: QCMethod): String = element.getNameIdentifier().getText()

    public static fun setName(element: QCMethod, newName: String): PsiElement {
        element.getNameIdentifier().replace(createIdentifier(element.getProject(), newName))
        return element
    }

}
