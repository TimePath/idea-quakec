package com.timepath.quakec.psi.ext

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.timepath.quakec.psi.QCIdentifier
import com.timepath.quakec.psi.impl.QCPsiImplUtil

abstract class QCIdentifierImplMixin(node: ASTNode) : ASTWrapperPsiElement(node), QCIdentifier {

    override fun getNameIdentifier(): QCIdentifier = tokenIdentifier as QCIdentifier

    override fun getName(): String? = nameIdentifier.text

    override fun setName(name: String): QCIdentifier {
        nameIdentifier.replace(QCPsiImplUtil.createIdentifier(project, name))
        return this
    }

    override fun getTextOffset(): Int = nameIdentifier.textOffset
}
