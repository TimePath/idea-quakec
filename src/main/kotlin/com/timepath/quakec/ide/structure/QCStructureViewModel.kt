package com.timepath.quakec.ide.structure

import com.intellij.ide.structureView.StructureViewModel
import com.intellij.ide.structureView.StructureViewModelBase
import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.ide.util.treeView.smartTree.Sorter
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiFile
import com.timepath.quakec.psi.QCFile
import com.timepath.quakec.psi.QCMethod
import com.timepath.quakec.psi.QCTypedef
import com.timepath.quakec.psi.QCVariable

class QCStructureViewModel(psiFile: PsiFile, editor: Editor) : StructureViewModelBase(psiFile, editor, QCStructureViewElement(psiFile as QCFile)), StructureViewModel.ElementInfoProvider {
    init {
        this.withSuitableClasses(QCVariable::class.java, QCMethod::class.java, QCTypedef::class.java)
    }

    override fun getSorters() = arrayOf(Sorter.ALPHA_SORTER)

    override fun isAlwaysShowsPlus(element: StructureViewTreeElement) = false

    override fun isAlwaysLeaf(element: StructureViewTreeElement) = element is QCStructureViewElement
}
