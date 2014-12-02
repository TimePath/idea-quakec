package com.timepath.quakec.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.timepath.quakec.psi.*;

/**
 * @author TimePath
 */
public class QCPsiImplUtil {

    public static String getName(QCVariable element) {
        return element.getIdentifier().getText();
    }

    public static PsiElement setName(QCVariable element, String newName) {
        ASTNode keyNode = element.getNode().findChildByType(QCTypes.IDENTIFIER);
        if (keyNode != null) {
            QCVariable property = QCElementFactory.create(element.getProject(), newName);
            ASTNode newKeyNode = property.getFirstChild().getNode();
            element.getNode().replaceChild(keyNode, newKeyNode);
        }
        return element;
    }

    public static PsiElement getNameIdentifier(QCVariable element) {
        ASTNode keyNode = element.getNode().findChildByType(QCTypes.IDENTIFIER);
        if (keyNode == null) return null;
        return keyNode.getPsi();
    }

    public static String getName(QCParameter element) {
        final QCIdentifier identifier = element.getIdentifier();
        if (identifier == null) return null;
        return identifier.getText();
    }

    public static PsiElement setName(QCParameter element, String newName) {
        ASTNode keyNode = element.getNode().findChildByType(QCTypes.IDENTIFIER);
        if (keyNode != null) {
            QCParameter property = QCElementFactory.create(element.getProject(), newName);
            ASTNode newKeyNode = property.getFirstChild().getNode();
            element.getNode().replaceChild(keyNode, newKeyNode);
        }
        return element;
    }

    public static PsiElement getNameIdentifier(QCParameter element) {
        ASTNode keyNode = element.getNode().findChildByType(QCTypes.IDENTIFIER);
        if (keyNode == null) return null;
        return keyNode.getPsi();
    }

}
