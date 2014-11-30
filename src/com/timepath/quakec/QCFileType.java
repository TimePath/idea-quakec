package com.timepath.quakec;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * @author TimePath
 */
public class QCFileType extends LanguageFileType {
    public static final QCFileType INSTANCE = new QCFileType();

    private QCFileType() {
        super(QCLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "QuakeC file";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "QuakeC file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "qc";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return QCIcons.FILE;
    }
}
