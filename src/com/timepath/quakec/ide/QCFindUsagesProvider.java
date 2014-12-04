package com.timepath.quakec.ide;

import com.intellij.lang.HelpID;
import com.intellij.lang.LanguageParserDefinitions;
import com.intellij.lang.cacheBuilder.DefaultWordsScanner;
import com.intellij.lang.cacheBuilder.WordsScanner;
import com.intellij.lang.findUsages.FindUsagesProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.tree.TokenSet;
import com.timepath.quakec.psi.QCMethod;
import com.timepath.quakec.psi.QCParameter;
import com.timepath.quakec.psi.QCTypes;
import com.timepath.quakec.psi.QCVariable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author TimePath
 */
public class QCFindUsagesProvider implements FindUsagesProvider {

    @Nullable
    @Override
    public WordsScanner getWordsScanner() {
        return new DefaultWordsScanner(LanguageParserDefinitions.INSTANCE.forLanguage(QCLanguage.INSTANCE).createLexer(null),
                TokenSet.create(QCTypes.IDENTIFIER),
                TokenSet.create(QCTypes.COMMENT),
                TokenSet.create(QCTypes.LITERAL)
        );
    }

    @Override
    public boolean canFindUsagesFor(@NotNull PsiElement psiElement) {
        return psiElement instanceof PsiNamedElement;
    }

    @Nullable
    @Override
    public String getHelpId(@NotNull PsiElement psiElement) {
        return HelpID.FIND_OTHER_USAGES;
    }

    @NotNull
    @Override
    public String getType(@NotNull PsiElement element) {
        if (element instanceof QCVariable) {
            return "variable";
        } else if (element instanceof QCParameter) {
            return "parameter";
        } else if (element instanceof QCMethod) {
            return "method";
        }
        return "";
    }

    @NotNull
    @Override
    public String getDescriptiveName(@NotNull PsiElement element) {
        final String name = element instanceof PsiNamedElement ? ((PsiNamedElement) element).getName() : null;
        return name != null ? name : "<unnamed>";
    }

    @NotNull
    @Override
    public String getNodeText(@NotNull PsiElement element, boolean useFullName) {
        return getDescriptiveName(element);
    }
}
