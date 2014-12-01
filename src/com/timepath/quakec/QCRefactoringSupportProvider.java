package com.timepath.quakec;

import com.intellij.lang.refactoring.RefactoringSupportProvider;
import com.intellij.psi.PsiElement;
import com.timepath.quakec.psi.QCIdentifier;

/**
 * @author TimePath
 */
public class QCRefactoringSupportProvider extends RefactoringSupportProvider {
    @Override
    public boolean isMemberInplaceRenameAvailable(PsiElement element, PsiElement context) {
        return element instanceof QCIdentifier;
    }
}
