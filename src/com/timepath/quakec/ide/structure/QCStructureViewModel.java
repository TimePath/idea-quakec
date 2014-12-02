package com.timepath.quakec.ide.structure;

import com.intellij.ide.structureView.StructureViewModel;
import com.intellij.ide.structureView.StructureViewModelBase;
import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.openapi.editor.Editor;
import com.intellij.psi.PsiFile;
import com.timepath.quakec.psi.QCVariable;
import com.timepath.quakec.psi.QCFile;
import com.timepath.quakec.psi.QCMethod;

/**
 * @author TimePath
 */
public class QCStructureViewModel extends StructureViewModelBase implements StructureViewModel.ElementInfoProvider {
    public QCStructureViewModel(PsiFile psiFile, Editor editor) {
        super(psiFile, editor, new QCStructureViewElement((QCFile) psiFile));
        this.withSuitableClasses(QCVariable.class, QCMethod.class);
    }

    @Override
    public boolean isAlwaysShowsPlus(StructureViewTreeElement element) {
        return false;
    }

    @Override
    public boolean isAlwaysLeaf(StructureViewTreeElement element) {
        return (element instanceof QCFile);
    }
}
