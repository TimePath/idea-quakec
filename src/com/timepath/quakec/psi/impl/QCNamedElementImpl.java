package com.timepath.quakec.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.timepath.quakec.psi.QCNamedElement;
import org.jetbrains.annotations.NotNull;

/**
 * @author TimePath
 */
public abstract class QCNamedElementImpl extends ASTWrapperPsiElement implements QCNamedElement {

    public QCNamedElementImpl(@NotNull ASTNode node) {
        super(node);
    }
}
