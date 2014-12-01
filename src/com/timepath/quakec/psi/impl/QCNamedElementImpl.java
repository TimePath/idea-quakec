package com.timepath.quakec.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.util.IncorrectOperationException;
import com.timepath.quakec.psi.QCNamedElement;
import com.timepath.quakec.psi.QCTypes;
import org.jetbrains.annotations.Nullable;

/**
 * @author TimePath
 */
public class QCNamedElementImpl extends ASTWrapperPsiElement implements QCNamedElement {

    public QCNamedElementImpl(ASTNode node) {
        super(node);
    }

    @Nullable
    @Override
    public PsiElement getNameIdentifier() {
        final ASTNode n = this.getNode().findChildByType(QCTypes.IDENTIFIER);
        return n != null ? n.getPsi() : null;
    }

    @Override
    public PsiElement setName(String s) throws IncorrectOperationException {
        return this;
    }
}
