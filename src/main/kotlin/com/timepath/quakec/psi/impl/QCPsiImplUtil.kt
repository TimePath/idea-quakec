package com.timepath.quakec.psi.impl

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFileFactory
import com.timepath.quakec.ide.file.QCFileType
import com.timepath.quakec.psi.QCFile
import com.timepath.quakec.psi.QCVariableDeclaration

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
        return variable.variableList[0].identifier
    }

}
