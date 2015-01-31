package com.timepath.quakec.psi.impl;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.timepath.quakec.ide.reference.QCReference;
import com.timepath.quakec.psi.*;
import org.jetbrains.annotations.NotNull;

import static com.timepath.quakec.psi.QCElementFactory.createIdentifier;

/**
 * @author TimePath
 */
public class QCPsiImplUtil {

    @NotNull
    public static String getName(QCIdentifier element) {
        return element.getNameIdentifier().getText();
    }

    public static PsiElement setName(QCIdentifier element, String newName) {
        element.replace(createIdentifier(element, newName));
        return element;
    }

    public static PsiReference getReference(QCIdentifier self) {
        return QCReference.create(self);
    }

    @NotNull
    public static String getName(QCTypedef element) {
        return element.getNameIdentifier().getText();
    }

    public static PsiElement setName(QCTypedef element, String newName) {
        element.getNameIdentifier().replace(createIdentifier(element, newName));
        return element;
    }

    public static String getName(QCParameter element) {
        final QCIdentifier nameIdentifier = element.getNameIdentifier();
        return nameIdentifier != null ? nameIdentifier.getText() : null;
    }

    public static PsiElement setName(QCParameter element, String newName) {
        final QCIdentifier nameIdentifier = element.getNameIdentifier();
        if (nameIdentifier != null) {
            nameIdentifier.replace(createIdentifier(element, newName));
        }
        return element;
    }

    @NotNull
    public static String getName(QCVariable element) {
        return element.getNameIdentifier().getText();
    }

    public static PsiElement setName(QCVariable element, String newName) {
        element.getNameIdentifier().replace(createIdentifier(element, newName));
        return element;
    }

    @NotNull
    public static String getName(QCMethod element) {
        return element.getNameIdentifier().getText();
    }

    public static PsiElement setName(QCMethod element, String newName) {
        element.getNameIdentifier().replace(createIdentifier(element, newName));
        return element;
    }

}
