package com.timepath.quakec;

import com.intellij.lang.BracePair;
import com.intellij.lang.PairedBraceMatcher;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import com.timepath.quakec.psi.QCTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author TimePath
 */
public class QCBraceMatcher implements PairedBraceMatcher {

    private static final BracePair[] PAIRS = new BracePair[]{
            new BracePair(QCTypes.BRACE_OPEN, QCTypes.BRACE_CLOSE, true),
            new BracePair(QCTypes.PAREN_OPEN, QCTypes.PAREN_CLOSE, false),
            new BracePair(QCTypes.INDEX_OPEN, QCTypes.INDEX_CLOSE, false),
    };

    @Override
    public BracePair[] getPairs() {
        return PAIRS;
    }

    @Override
    public boolean isPairedBracesAllowedBeforeType(@NotNull IElementType lbraceType, @Nullable IElementType contextType) {
        return true;
    }

    @Override
    public int getCodeConstructStart(PsiFile file, int openingBraceOffset) {
        return openingBraceOffset;
    }
}
