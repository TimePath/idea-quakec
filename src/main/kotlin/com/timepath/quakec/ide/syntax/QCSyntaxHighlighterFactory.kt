package com.timepath.quakec.ide.syntax

import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory

class QCSyntaxHighlighterFactory : SingleLazyInstanceSyntaxHighlighterFactory() {
    override fun createHighlighter() = QCSyntaxHighlighter()
}
