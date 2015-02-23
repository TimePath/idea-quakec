package com.timepath.quakec.ide

import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.PlatformPatterns
import com.intellij.util.ProcessingContext
import com.timepath.quakec.psi.QCTypes

/**
 * @author TimePath
 */
public class QCCompletionContributor : CompletionContributor() {
    {
        extend(CompletionType.BASIC, PlatformPatterns.psiElement(QCTypes.TOKEN_IDENTIFIER).withLanguage(QCLanguage), object : CompletionProvider<CompletionParameters>() {
            override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, resultSet: CompletionResultSet) {
                resultSet.addElement(LookupElementBuilder.create("Hello"))
            }
        })
    }
}
