package com.timepath.quakec.psi

import com.intellij.openapi.util.TextRange
import com.intellij.psi.AbstractElementManipulator
import com.timepath.quakec.psi.ext.QCIdentifierImplMixin

class QCIdentifierManipulator : AbstractElementManipulator<QCIdentifier>() {

    override fun handleContentChange(element: QCIdentifier, range: TextRange, newContent: String): QCIdentifier {
        val s = range.replace(element.text, newContent)
        (element as QCIdentifierImplMixin).setName(s)
        return element
    }
}
