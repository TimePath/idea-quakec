package com.timepath.quakec.ide

import com.intellij.lang.ASTNode
import com.intellij.lang.folding.FoldingBuilder
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.editor.Document
import com.timepath.quakec.psi.QCTypes

import java.util.ArrayList

/**
 * @author TimePath
 */
public class QCFoldingBuilder : FoldingBuilder {
    override fun buildFoldRegions(node: ASTNode, document: Document): Array<FoldingDescriptor> {
        val list = ArrayList<FoldingDescriptor>()
        buildFolding(node, list)
        return list.toArray<FoldingDescriptor>(arrayOfNulls<FoldingDescriptor>(list.size()))
    }

    private fun buildFolding(node: ASTNode, list: MutableList<FoldingDescriptor>) {
        val elementType = node.getElementType()
        if (elementType == QCTypes.BLOCK || elementType == QCTypes.BLOCK_SWITCH) {
            val range = node.getTextRange()
            list.add(FoldingDescriptor(node, range))
        }
        for (child in node.getChildren(null)) {
            buildFolding(child, list)
        }
    }

    override fun getPlaceholderText(node: ASTNode) = "{...}"

    override fun isCollapsedByDefault(node: ASTNode) = false
}
