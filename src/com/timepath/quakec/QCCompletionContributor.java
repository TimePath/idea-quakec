package com.timepath.quakec;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.util.ProcessingContext;
import com.timepath.quakec.psi.QCTypes;
import org.jetbrains.annotations.NotNull;

/**
 * @author TimePath
 */
public class QCCompletionContributor extends CompletionContributor {
    public QCCompletionContributor() {
        extend(CompletionType.BASIC,
                PlatformPatterns.psiElement(QCTypes.ID).withLanguage(QCLanguage.INSTANCE),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        resultSet.addElement(LookupElementBuilder.create("Hello"));
                    }
                }
        );
    }
}
