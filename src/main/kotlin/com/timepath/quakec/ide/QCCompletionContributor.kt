package com.timepath.quakec.ide

import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.PlatformPatterns
import com.intellij.util.ProcessingContext
import com.timepath.quakec.psi.QCTypes

public class QCCompletionContributor : CompletionContributor() {
    init {
        extend(CompletionType.BASIC, PlatformPatterns.psiElement(QCTypes.TOKEN_IDENTIFIER).withLanguage(QCLanguage), object : CompletionProvider<CompletionParameters>() {
            override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, resultSet: CompletionResultSet) {
                resultSet.addElement(LookupElementBuilder.create("Hello"))
            }
        })
    }
}
