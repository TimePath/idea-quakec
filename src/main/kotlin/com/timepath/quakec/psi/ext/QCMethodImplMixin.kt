package com.timepath.quakec.psi.ext

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.timepath.quakec.psi.QCIdentifier
import com.timepath.quakec.psi.QCMethod
import com.timepath.quakec.psi.impl.QCPsiImplUtil

abstract class QCMethodImplMixin(node: ASTNode) : ASTWrapperPsiElement(node), QCMethod {

    fun getNameIdentifier(): QCIdentifier = identifierList.first()

    override fun getName(): String? = getNameIdentifier().text

    override fun setName(name: String): QCMethod {
        getNameIdentifier().replace(QCPsiImplUtil.createIdentifier(project, name))
        return this
    }

    override fun getTextOffset(): Int = getNameIdentifier().textOffset
}
