package com.timepath.quakec.ide

import com.intellij.lang.HelpID
import com.intellij.lang.LanguageParserDefinitions
import com.intellij.lang.cacheBuilder.DefaultWordsScanner
import com.intellij.lang.cacheBuilder.WordsScanner
import com.intellij.lang.findUsages.FindUsagesProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import com.intellij.psi.tree.TokenSet
import com.timepath.quakec.psi.QCMethod
import com.timepath.quakec.psi.QCParameter
import com.timepath.quakec.psi.QCTypes
import com.timepath.quakec.psi.QCVariable

class QCFindUsagesProvider : FindUsagesProvider {

    override fun getWordsScanner(): WordsScanner? {
        return DefaultWordsScanner(LanguageParserDefinitions.INSTANCE.forLanguage(QCLanguage).createLexer(null),
                TokenSet.create(QCTypes.IDENTIFIER),
                TokenSet.create(QCTypes.COMMENT),
                TokenSet.create(QCTypes.LITERAL)
        )
    }

    override fun canFindUsagesFor(psiElement: PsiElement) = psiElement is PsiNamedElement

    override fun getHelpId(psiElement: PsiElement) = HelpID.FIND_OTHER_USAGES

    override fun getType(element: PsiElement) = when (element) {
        is QCVariable -> "variable"
        is QCParameter -> "parameter"
        is QCMethod -> "method"
        else -> ""
    }

    override fun getDescriptiveName(element: PsiElement) = when (element) {
        is PsiNamedElement -> element.name
        else -> null
    } ?: "<unnamed>"

    override fun getNodeText(element: PsiElement, useFullName: Boolean) = getDescriptiveName(element)
}
