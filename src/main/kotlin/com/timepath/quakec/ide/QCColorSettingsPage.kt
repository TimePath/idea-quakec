package com.timepath.quakec.ide

import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import com.timepath.quakec.icons.QCIcons
import com.timepath.quakec.ide.syntax.QCSyntaxHighlighter

public class QCColorSettingsPage : ColorSettingsPage {

    override fun getIcon() = QCIcons.File

    override fun getHighlighter() = QCSyntaxHighlighter()

    override fun getDemoText(): String {
        return """
const string a = \"7\";
// Comment
/*
float a, b = 7;
*/
#if 0
float a = 7, b;
#endif
a = 7;
a = (7 * a + 9 / 2);
"""
    }

    override fun getAdditionalHighlightingTagToDescriptorMap() = null

    override fun getAttributeDescriptors() = QCSyntaxHighlighter.DESCRIPTORS

    override fun getColorDescriptors() = ColorDescriptor.EMPTY_ARRAY

    override fun getDisplayName() = "QuakeC"
}
