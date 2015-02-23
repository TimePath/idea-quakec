package com.timepath.quakec.ide.structure

import com.timepath.quakec.psi.*
import com.intellij.ide.structureView.*
import com.intellij.ide.util.treeView.smartTree.Sorter
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiFile

/**
 * @author TimePath
 */
public class QCStructureViewModel(psiFile: PsiFile, editor: Editor) : StructureViewModelBase(psiFile, editor, QCStructureViewElement(psiFile as QCFile)), StructureViewModel.ElementInfoProvider {
    {
        this.withSuitableClasses(javaClass<QCVariable>(), javaClass<QCMethod>(), javaClass<QCTypedef>())
    }

    override fun getSorters() = array(Sorter.ALPHA_SORTER)

    override fun isAlwaysShowsPlus(element: StructureViewTreeElement): Boolean {
        return false
    }

    override fun isAlwaysLeaf(element: StructureViewTreeElement): Boolean {
        return (element is QCStructureViewElement)
    }
}
