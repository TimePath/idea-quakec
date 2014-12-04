package com.timepath.quakec.ide.structure;

import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement;
import com.intellij.ide.util.treeView.smartTree.TreeElement;
import com.intellij.navigation.ItemPresentation;
import com.intellij.navigation.NavigationItem;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.PlatformIcons;
import com.intellij.util.containers.ContainerUtil;
import com.timepath.quakec.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.List;

/**
 * @author TimePath
 */
public class QCStructureViewElement implements StructureViewTreeElement {
    private QCFile root;

    public QCStructureViewElement(QCFile root) {
        this.root = root;
    }

    @Override
    public Object getValue() {
        return root;
    }

    @Override
    public void navigate(boolean requestFocus) {
        root.navigate(requestFocus);
    }

    @Override
    public boolean canNavigate() {
        return root.canNavigate();
    }

    @Override
    public boolean canNavigateToSource() {
        return root.canNavigateToSource();
    }

    @NotNull
    @Override
    public ItemPresentation getPresentation() {
        return root.getPresentation();
    }

    @NotNull
    @Override
    public TreeElement[] getChildren() {
        class Child implements StructureViewTreeElement, SortableTreeElement {

            private final
            @NotNull
            PsiNamedElement element;
            private final Icon i;

            Child(@NotNull PsiNamedElement element, Icon icon) {
                this.element = element;
                this.i = icon;
            }

            @Override
            public Object getValue() {
                return element;
            }

            @Override
            public void navigate(boolean requestFocus) {
                if (element instanceof NavigationItem) {
                    ((NavigationItem) element).navigate(requestFocus);
                }
            }

            @Override
            public boolean canNavigate() {
                return element instanceof NavigationItem && ((NavigationItem) element).canNavigate();
            }

            @Override
            public boolean canNavigateToSource() {
                return element instanceof NavigationItem && ((NavigationItem) element).canNavigateToSource();
            }

            @NotNull
            @Override
            public String getAlphaSortKey() {
                String name = element.getName();
                return name != null ? name : "";
            }

            @NotNull
            @Override
            public ItemPresentation getPresentation() {
                return new ItemPresentation() {
                    @Nullable
                    @Override
                    public String getPresentableText() {
                        return element.getName();
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
        List<TreeElement> treeElements = ContainerUtil.newArrayList();
        List<QCTypedef> types = PsiTreeUtil.getChildrenOfTypeAsList(root, QCTypedef.class);
        for (QCTypedef e : types) {
            treeElements.add(new Child(e, PlatformIcons.INTERFACE_ICON));
        }
        List<QCVariableDeclaration> vars = PsiTreeUtil.getChildrenOfTypeAsList(root, QCVariableDeclaration.class);
        for (QCVariableDeclaration declaration : vars) {
            Icon icon = declaration.getType().getText().startsWith(".")
                    ? PlatformIcons.FIELD_ICON
                    : PlatformIcons.VARIABLE_ICON;
            for (QCVariable variable : PsiTreeUtil.getChildrenOfTypeAsList(declaration, QCVariable.class)) {
                treeElements.add(new Child(variable, icon));
            }
        }
        List<QCMethod> funcs = PsiTreeUtil.getChildrenOfTypeAsList(root, QCMethod.class);
        for (QCMethod declaration : funcs) {
            QCType type = declaration.getType();
            Icon icon = type != null && type.getText().startsWith(".")
                    ? PlatformIcons.METHOD_ICON
                    : PlatformIcons.FUNCTION_ICON;
            treeElements.add(new Child(declaration, icon));
        }
        return treeElements.toArray(new TreeElement[treeElements.size()]);
    }
}
