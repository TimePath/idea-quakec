package com.timepath.quakec.psi.impl;

import com.intellij.psi.PsiElement;
import com.timepath.quakec.psi.*;

/**
 * @author TimePath
 */
public class QCPsiImplUtil {

    private static PsiElement createIdentifierNode(PsiElement element, String newName) {
        QCVariableDeclaration variable = QCElementFactory.create(element.getProject(), "void " + newName + ";");
        return variable.getVariableList().get(0).getNameIdentifier();
    }

    public static String getName(QCIdentifier element) {
        return element.getNameIdentifier().getText();
    }

    public static PsiElement setName(QCIdentifier element, String newName) {
        element.replace(createIdentifierNode(element, newName));
        return element;
    }

    public static String getName(QCTypedef element) {
        return element.getNameIdentifier().getText();
    }

    public static PsiElement setName(QCTypedef element, String newName) {
        element.getNameIdentifier().replace(createIdentifierNode(element, newName));
        return element;
    }

    public static String getName(QCParameter element) {
        final QCIdentifier nameIdentifier = element.getNameIdentifier();
        return nameIdentifier != null ? nameIdentifier.getText() : null;
    }

    public static PsiElement setName(QCParameter element, String newName) {
        final QCIdentifier nameIdentifier = element.getNameIdentifier();
        if (nameIdentifier != null) {
            nameIdentifier.replace(createIdentifierNode(element, newName));
        }
        return element;
    }

    public static String getName(QCVariable element) {
        return element.getNameIdentifier().getText();
    }

    public static PsiElement setName(QCVariable element, String newName) {
        element.getNameIdentifier().replace(createIdentifierNode(element, newName));
        return element;
    }

    public static String getName(QCMethod element) {
        return element.getNameIdentifier().getText();
    }

    public static PsiElement setName(QCMethod element, String newName) {
        element.getNameIdentifier().replace(createIdentifierNode(element, newName));
        return element;
    }

}
