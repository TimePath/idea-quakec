package com.timepath.quakec.ide.structure

import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement
import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.navigation.ItemPresentation
import com.intellij.navigation.NavigationItem
import com.intellij.psi.PsiNamedElement
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.PlatformIcons
import com.intellij.util.containers.ContainerUtil
import com.timepath.quakec.psi.*
import javax.swing.Icon

public class QCStructureViewElement(private val root: QCFile) : StructureViewTreeElement {

    override fun getValue() = root

    override fun navigate(requestFocus: Boolean) {
        root.navigate(requestFocus)
    }

    override fun canNavigate() = root.canNavigate()

    override fun canNavigateToSource() = root.canNavigateToSource()

    override fun getPresentation() = root.getPresentation()

    override fun getChildren(): Array<TreeElement> {
        class Child(private val element: PsiNamedElement, private val i: Icon) : StructureViewTreeElement, SortableTreeElement {

            override fun getValue() = element

            override fun navigate(requestFocus: Boolean) {
                if (element is NavigationItem) {
                    element.navigate(requestFocus)
                }
            }

            override fun canNavigate(): Boolean {
                return element is NavigationItem && element.canNavigate()
            }

            override fun canNavigateToSource(): Boolean {
                return element is NavigationItem && element.canNavigateToSource()
            }

            override fun getAlphaSortKey() = element.getName() ?: ""

            override fun getPresentation(): ItemPresentation {
                return object : ItemPresentation {
                    override fun getPresentableText() = element.getName()

                    override fun getLocationString() = null

                    override fun getIcon(b: Boolean) = i
                }
            }

            override fun getChildren() = StructureViewTreeElement.EMPTY_ARRAY
        }

        val treeElements = ContainerUtil.newArrayList<TreeElement>()
        val types = PsiTreeUtil.getChildrenOfTypeAsList<QCTypedef>(root, javaClass<QCTypedef>())
        for (e in types) {
            treeElements.add(Child(e, PlatformIcons.INTERFACE_ICON))
        }
        val vars = PsiTreeUtil.getChildrenOfTypeAsList<QCVariableDeclaration>(root, javaClass<QCVariableDeclaration>())
        for (declaration in vars) {
            val icon = when {
                declaration.getType().getText().startsWith(".") -> PlatformIcons.FIELD_ICON
                else -> PlatformIcons.VARIABLE_ICON
            }
            for (variable in PsiTreeUtil.getChildrenOfTypeAsList<QCVariable>(declaration, javaClass<QCVariable>())) {
                treeElements.add(Child(variable, icon))
            }
        }
        val funcs = PsiTreeUtil.getChildrenOfTypeAsList<QCMethod>(root, javaClass<QCMethod>())
        for (declaration in funcs) {
            val type = declaration.getType()
            val icon = when {
                type != null && type.getText().startsWith(".") -> PlatformIcons.METHOD_ICON
                else -> PlatformIcons.FUNCTION_ICON
            }
            treeElements.add(Child(declaration, icon))
        }
        return treeElements.copyToArray()
    }
}
