package com.timepath.quakec.psi.impl

import kotlin.platform.platformStatic as static
import com.timepath.quakec.psi.*
import com.timepath.quakec.ide.file.QCFileType
import com.timepath.quakec.ide.reference.QCReference
import com.intellij.openapi.project.Project
import com.intellij.psi.*

/**
 * @author TimePath
 */
public object QCPsiImplUtil {

    fun createFile(project: Project, text: String): QCFile {
        val name = "dummy.qc"
        return PsiFileFactory.getInstance(project).createFileFromText(name, QCFileType, text) as QCFile
    }

    fun <T> create(project: Project, newName: String): T {
        return createFile(project, newName).getFirstChild() as T
    }

    fun createIdentifier(element: PsiElement, newName: String): PsiElement {
        val variable = create<QCVariableDeclaration>(element.getProject(), "void " + newName + ";")
        return variable.getVariableList().get(0).getNameIdentifier()
    }

    public static fun getName(element: QCIdentifier): String {
        return element.getNameIdentifier().getText()
    }

    public static fun setName(element: QCIdentifier, newName: String): PsiElement {
        element.replace(createIdentifier(element, newName))
        return element
    }

    public static fun getReference(self: QCIdentifier): PsiReferenceBase<out PsiElement>? {
        return QCReference.create(self)
    }

    public static fun getName(element: QCTypedef): String {
        return element.getNameIdentifier().getText()
    }

    public static fun setName(element: QCTypedef, newName: String): PsiElement {
        element.getNameIdentifier().replace(createIdentifier(element, newName))
        return element
    }

    public static fun getName(element: QCParameter): String? {
        return element.getNameIdentifier()?.getText()
    }

    public static fun setName(element: QCParameter, newName: String): PsiElement {
        element.getNameIdentifier()?.replace(createIdentifier(element, newName))
        return element
    }

    public static fun getName(element: QCVariable): String {
        return element.getNameIdentifier().getText()
    }

    public static fun setName(element: QCVariable, newName: String): PsiElement {
        element.getNameIdentifier().replace(createIdentifier(element, newName))
        return element
    }

    public static fun getName(element: QCMethod): String {
        return element.getNameIdentifier().getText()
    }

    public static fun setName(element: QCMethod, newName: String): PsiElement {
        element.getNameIdentifier().replace(createIdentifier(element, newName))
        return element
    }

}
