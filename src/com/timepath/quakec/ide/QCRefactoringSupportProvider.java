package com.timepath.quakec.ide;

import com.intellij.lang.refactoring.RefactoringSupportProvider;
import com.intellij.psi.PsiElement;
import com.timepath.quakec.psi.QCNamedElement;
import org.jetbrains.annotations.NotNull;

/**
 * @author TimePath
 */
public class QCRefactoringSupportProvider extends RefactoringSupportProvider {
    @Override
    public boolean isMemberInplaceRenameAvailable(@NotNull PsiElement element, PsiElement context) {
        return element instanceof QCNamedElement;
    }
}
