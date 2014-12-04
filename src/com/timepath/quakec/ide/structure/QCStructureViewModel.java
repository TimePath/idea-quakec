package com.timepath.quakec.ide.structure;

import com.intellij.ide.structureView.StructureViewModel;
import com.intellij.ide.structureView.StructureViewModelBase;
import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.Sorter;
import com.intellij.openapi.editor.Editor;
import com.intellij.psi.PsiFile;
import com.timepath.quakec.psi.QCFile;
import com.timepath.quakec.psi.QCMethod;
import com.timepath.quakec.psi.QCTypedef;
import com.timepath.quakec.psi.QCVariable;
import org.jetbrains.annotations.NotNull;

/**
 * @author TimePath
 */
public class QCStructureViewModel extends StructureViewModelBase implements StructureViewModel.ElementInfoProvider {
    public QCStructureViewModel(PsiFile psiFile, Editor editor) {
        super(psiFile, editor, new QCStructureViewElement((QCFile) psiFile));
        this.withSuitableClasses(QCVariable.class, QCMethod.class, QCTypedef.class);
    }

    @NotNull
    public Sorter[] getSorters() {
        return new Sorter[]{Sorter.ALPHA_SORTER};
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
