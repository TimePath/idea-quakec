package com.timepath.quakec.psi.ext

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.timepath.quakec.psi.QCIdentifier
import com.timepath.quakec.psi.QCVariable
import com.timepath.quakec.psi.impl.QCPsiImplUtil

abstract class QCVariableImplMixin(node: ASTNode) : ASTWrapperPsiElement(node), QCVariable {

    fun getNameIdentifier(): QCIdentifier = identifier

    override fun getName(): String? = getNameIdentifier().text

    override fun setName(name: String): QCVariable {
        getNameIdentifier().replace(QCPsiImplUtil.createIdentifier(project, name))
        return this
    }

    override fun getTextOffset(): Int = getNameIdentifier().textOffset
}
