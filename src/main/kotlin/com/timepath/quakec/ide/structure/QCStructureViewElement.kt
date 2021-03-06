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

class QCStructureViewElement(private val root: QCFile) : StructureViewTreeElement {

    override fun getValue() = root

    override fun navigate(requestFocus: Boolean) = root.navigate(requestFocus)

    override fun canNavigate() = root.canNavigate()

    override fun canNavigateToSource() = root.canNavigateToSource()

    override fun getPresentation() = root.presentation!!

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

            override fun getAlphaSortKey() = element.name ?: ""

            override fun getPresentation(): ItemPresentation {
                return object : ItemPresentation {
                    override fun getPresentableText() = element.name

                    override fun getLocationString() = null

                    override fun getIcon(b: Boolean) = i
                }
            }

            override fun getChildren() = StructureViewTreeElement.EMPTY_ARRAY
        }

        val treeElements = ContainerUtil.newArrayList<TreeElement>()
        val types = PsiTreeUtil.getChildrenOfTypeAsList(root, QCTypedef::class.java)
        types.mapTo(treeElements) { Child(it, PlatformIcons.INTERFACE_ICON) }
        val vars = PsiTreeUtil.getChildrenOfTypeAsList(root, QCVariableDeclaration::class.java)
        for (declaration in vars) {
            val icon = when {
                declaration.type.text.startsWith(".") -> PlatformIcons.FIELD_ICON
                else -> PlatformIcons.VARIABLE_ICON
            }
            PsiTreeUtil.getChildrenOfTypeAsList(declaration, QCVariable::class.java).mapTo(treeElements) { Child(it, icon) }
        }
        val funcs = PsiTreeUtil.getChildrenOfTypeAsList(root, QCMethod::class.java)
        for (declaration in funcs) {
            val type = declaration.type
            val icon = when {
                type != null && type.text.startsWith(".") -> PlatformIcons.METHOD_ICON
                else -> PlatformIcons.FUNCTION_ICON
            }
            treeElements.add(Child(declaration, icon))
        }
        return treeElements.toTypedArray()
    }
}
