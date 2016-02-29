package com.timepath.quakec.ide

import com.intellij.lang.ASTNode
import com.intellij.lang.folding.FoldingBuilder
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.editor.Document
import com.timepath.quakec.psi.QCTypes

import java.util.ArrayList

class QCFoldingBuilder : FoldingBuilder {
    override fun buildFoldRegions(node: ASTNode, document: Document): Array<FoldingDescriptor> {
        val list = ArrayList<FoldingDescriptor>()
        buildFolding(node, list)
        return list.toTypedArray()
    }

    private fun buildFolding(node: ASTNode, list: MutableList<FoldingDescriptor>) {
        val elementType = node.elementType
        if (elementType == QCTypes.BLOCK || elementType == QCTypes.BLOCK_SWITCH) {
            val range = node.textRange
            list.add(FoldingDescriptor(node, range))
        }
        for (child in node.getChildren(null)) {
            buildFolding(child, list)
        }
    }

    override fun getPlaceholderText(node: ASTNode) = "{...}"

    override fun isCollapsedByDefault(node: ASTNode) = false
}
