package com.timepath.quakec.ide.syntax;

import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import org.jetbrains.annotations.NotNull;

/**
 * @author TimePath
 */
public class QCSyntaxHighlighterFactory extends SingleLazyInstanceSyntaxHighlighterFactory {
    @NotNull
    @Override
    public SyntaxHighlighter createHighlighter() {
        return new QCSyntaxHighlighter();
    }
}
