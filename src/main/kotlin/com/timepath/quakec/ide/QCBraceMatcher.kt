package com.timepath.quakec.ide

import com.intellij.lang.BracePair
import com.intellij.lang.PairedBraceMatcher
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType
import com.timepath.quakec.psi.QCTypes

public class QCBraceMatcher : PairedBraceMatcher {

    override fun getPairs() = PAIRS

    override fun isPairedBracesAllowedBeforeType(lbraceType: IElementType, contextType: IElementType?): Boolean {
        return true
    }

    override fun getCodeConstructStart(file: PsiFile, openingBraceOffset: Int): Int {
        return openingBraceOffset
    }

    companion object {

        private val PAIRS = arrayOf(
                BracePair(QCTypes.BRACE_OPEN, QCTypes.BRACE_CLOSE, true),
                BracePair(QCTypes.PAREN_OPEN, QCTypes.PAREN_CLOSE, false),
                BracePair(QCTypes.INDEX_OPEN, QCTypes.INDEX_CLOSE, false)
        )
    }
}
