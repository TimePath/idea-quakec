package com.timepath.quakec.ide.file

import com.intellij.openapi.fileTypes.LanguageFileType
import com.timepath.quakec.icons.QCIcons
import com.timepath.quakec.ide.QCLanguage

/**
 * @author TimePath
 */
public object QCFileType : LanguageFileType(QCLanguage) {

    override fun getName() = "QuakeC file"

    override fun getDescription() = "QuakeC file"

    override fun getDefaultExtension() = "qc"

    override fun getIcon() = QCIcons.FILE

}
