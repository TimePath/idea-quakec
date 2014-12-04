package com.timepath.quakec.ide.structure;

import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.TreeElement;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.PlatformIcons;
import com.intellij.util.containers.ContainerUtil;
import com.timepath.quakec.psi.QCFile;
import com.timepath.quakec.psi.QCMethod;
import com.timepath.quakec.psi.QCVariable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.List;

/**
 * @author TimePath
 */
public class QCStructureViewElement implements StructureViewTreeElement {
    private QCFile element;

    public QCStructureViewElement(QCFile element) {
        this.element = element;
    }

    @Override
    public Object getValue() {
        return element;
    }

    @Override
    public void navigate(boolean requestFocus) {
        element.navigate(requestFocus);
    }

    @Override
    public boolean canNavigate() {
        return element.canNavigate();
    }

    @Override
    public boolean canNavigateToSource() {
        return element.canNavigateToSource();
    }

    @NotNull
    @Override
    public ItemPresentation getPresentation() {
        return element.getPresentation();
    }

    @NotNull
    @Override
    public TreeElement[] getChildren() {
        List<QCVariable> vars = PsiTreeUtil.getChildrenOfTypeAsList(element, QCVariable.class);
        List<QCMethod> funcs = PsiTreeUtil.getChildrenOfTypeAsList(element, QCMethod.class);
        List<TreeElement> treeElements = ContainerUtil.newArrayListWithCapacity(vars.size() + funcs.size());
        class Child implements StructureViewTreeElement {

            private final PsiNamedElement e;
            private final Icon i;

            Child(PsiNamedElement element, Icon icon) {
                this.e = element;
                this.i = icon;
            }

            @Override
            public void navigate(boolean b) {

            }

            @Override
            public boolean canNavigate() {
                return false;
            }

            @Override
            public boolean canNavigateToSource() {
                return false;
            }

            @Override
            public Object getValue() {
                return e;
            }

            @NotNull
            @Override
            public ItemPresentation getPresentation() {
                return new ItemPresentation() {
                    @Nullable
                    @Override
                    public String getPresentableText() {
                        return e.getName();
                    }

                    @Nullable
                    @Override
                    public String getLocationString() {
                        return null;
                    }

                    @Nullable
                    @Override
                    public Icon getIcon(boolean b) {
                        return i;
                    }
                };
            }

            @NotNull
            @Override
            public TreeElement[] getChildren() {
                return EMPTY_ARRAY;
            }
        }
        if (vars != null) {
            for (final QCVariable e : vars) {
                treeElements.add(new Child(e, PlatformIcons.VARIABLE_ICON));
            }
        }
        if (funcs != null) {
            for (final QCMethod e : funcs) {
                treeElements.add(new Child(e, PlatformIcons.FUNCTION_ICON));
            }
        }
        return treeElements.toArray(new TreeElement[treeElements.size()]);
    }
}
