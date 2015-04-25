package com.timepath.quakec.ide.syntax

import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory

public class QCSyntaxHighlighterFactory : SingleLazyInstanceSyntaxHighlighterFactory() {
    override fun createHighlighter() = QCSyntaxHighlighter()
}
