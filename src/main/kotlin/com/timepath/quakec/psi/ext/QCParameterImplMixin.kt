package com.timepath.quakec.psi.ext

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.timepath.quakec.psi.QCIdentifier
import com.timepath.quakec.psi.QCParameter
import com.timepath.quakec.psi.impl.QCPsiImplUtil

abstract class QCParameterImplMixin(node: ASTNode) : ASTWrapperPsiElement(node), QCParameter {

    fun getNameIdentifier(): QCIdentifier? = identifier

    override fun getName(): String? = getNameIdentifier()?.text

    override fun setName(name: String): QCParameter {
        getNameIdentifier()?.replace(QCPsiImplUtil.createIdentifier(project, name))
        return this
    }

    override fun getTextOffset(): Int = getNameIdentifier()?.textOffset ?: 0
}
