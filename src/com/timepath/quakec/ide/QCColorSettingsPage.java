package com.timepath.quakec.ide;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import com.timepath.quakec.icons.QCIcons;
import com.timepath.quakec.ide.syntax.QCSyntaxHighlighter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

/**
 * @author TimePath
 */
public class QCColorSettingsPage implements ColorSettingsPage {

    @Nullable
    @Override
    public Icon getIcon() {
        return QCIcons.FILE;
    }

    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter() {
        return new QCSyntaxHighlighter();
    }

    @NotNull
    @Override
    public String getDemoText() {
        return "const string a = \"7\";\n" +
                "// Comment\n" +
                "/*\n" +
                "float a, b = 7;\n" +
                "*/\n" +
                "#if 0\n" +
                "local float a = 7, b;\n" +
                "#endif\n" +
                "a = 7;\n" +
                "a = (7 * a + 9 / 2);\n";
    }

    @Nullable
    @Override
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @NotNull
    @Override
    public AttributesDescriptor[] getAttributeDescriptors() {
        return QCSyntaxHighlighter.DESCRIPTORS;
    }

    @NotNull
    @Override
    public ColorDescriptor[] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "QuakeC";
    }
}
