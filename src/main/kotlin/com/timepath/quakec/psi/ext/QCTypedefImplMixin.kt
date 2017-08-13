package com.timepath.quakec.psi.ext

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.timepath.quakec.psi.QCIdentifier
import com.timepath.quakec.psi.QCTypedef
import com.timepath.quakec.psi.impl.QCPsiImplUtil

abstract class QCTypedefImplMixin(node: ASTNode) : ASTWrapperPsiElement(node), QCTypedef {

    fun getNameIdentifier(): QCIdentifier = identifier

    override fun getName(): String? = getNameIdentifier().text

    override fun setName(name: String): QCTypedef {
        getNameIdentifier().replace(QCPsiImplUtil.createIdentifier(project, name))
        return this
    }

    override fun getTextOffset(): Int = getNameIdentifier().textOffset
}
