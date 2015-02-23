package com.timepath.quakec.psi

import com.intellij.psi.tree.IElementType
import com.timepath.quakec.ide.QCLanguage
import org.jetbrains.annotations.NonNls

/**
 * @author TimePath
 */
public class QCTokenType(NonNls debugName: String) : IElementType(debugName, QCLanguage) {

    override fun toString() = "TokenTypeImpl." + super.toString()
}
