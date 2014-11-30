package com.timepath.quakec.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.timepath.quakec.QCFileType;
import com.timepath.quakec.QCLanguage;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * @author TimePath
 */
public class QCFile extends PsiFileBase {
    public QCFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, QCLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return QCFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "QuakeC File";
    }

    @Override
    public Icon getIcon(int flags) {
        return super.getIcon(flags);
    }
}
