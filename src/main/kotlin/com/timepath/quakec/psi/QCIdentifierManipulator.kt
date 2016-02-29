package com.timepath.quakec.psi

import com.intellij.openapi.util.TextRange
import com.intellij.psi.AbstractElementManipulator

class QCIdentifierManipulator : AbstractElementManipulator<QCIdentifier>() {

    override fun handleContentChange(element: QCIdentifier, range: TextRange, newContent: String): QCIdentifier {
        val s = range.replace(element.text, newContent)
        element.name = s
        return element
    }
}
