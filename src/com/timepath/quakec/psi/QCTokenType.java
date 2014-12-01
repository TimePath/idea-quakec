package com.timepath.quakec.psi;

import com.intellij.psi.tree.IElementType;
import com.timepath.quakec.QCLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

/**
 * @author TimePath
 */
public class QCTokenType extends IElementType {
    public QCTokenType(@NotNull @NonNls String debugName) {
        super(debugName, QCLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "QCTokenType." + super.toString();
    }
}
