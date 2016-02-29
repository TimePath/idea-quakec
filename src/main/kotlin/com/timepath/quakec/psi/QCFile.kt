package com.timepath.quakec.psi

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.psi.FileViewProvider
import com.timepath.quakec.ide.QCLanguage
import com.timepath.quakec.ide.file.QCFileType

class QCFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, QCLanguage) {

    override fun getFileType() = QCFileType

    override fun toString() = "QuakeC File"

}
