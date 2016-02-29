package com.timepath.quakec.psi

import com.intellij.psi.tree.IElementType
import com.timepath.quakec.ide.QCLanguage
import org.jetbrains.annotations.NonNls

class QCElementType(@NonNls debugName: String) : IElementType(debugName, QCLanguage)
