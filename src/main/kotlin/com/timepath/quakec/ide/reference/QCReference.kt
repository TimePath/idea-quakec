package com.timepath.quakec.ide.reference

import com.intellij.openapi.fileTypes.FileType
import com.intellij.openapi.util.Comparing
import com.intellij.openapi.util.TextRange
import com.intellij.psi.*
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.util.CachedValueProvider
import com.intellij.psi.util.CachedValuesManager
import com.intellij.util.ArrayUtil
import com.intellij.util.CommonProcessors.CollectProcessor
import com.intellij.util.CommonProcessors.FindProcessor
import com.intellij.util.Processor
import com.intellij.util.containers.ContainerUtil
import com.intellij.util.indexing.FileBasedIndex
import com.timepath.quakec.ide.file.QCFileType
import com.timepath.quakec.psi.*

public class QCReference private constructor(element: PsiElement)
: PsiReferenceBase<PsiElement>(element, TextRange.allOf(element.getText())), PsiPolyVariantReference {

    private val key = element.getText()

    private fun isScopeElement(element: PsiElement): Boolean {
        return isBlockElement(element) || element is QCMethod || element is QCFile
    }

    private fun isBlockElement(element: PsiElement?): Boolean {
        return element is QCBlock || element is QCBlockSwitch
    }

    private fun getScopes(): List<PsiElement> {
        val scopes = ContainerUtil.newLinkedList<PsiElement>()
        var e = getElement()
        while (true) {
            e = e.getParent()
            if (e == null) break
            if (isScopeElement(e)) {
                scopes.add(e)
            }
        }
        val project = getElement().getProject()
        val psiManager = PsiManager.getInstance(project)
        val fileBasedIndex = FileBasedIndex.getInstance()
        val files = fileBasedIndex.getContainingFiles<FileType, Void>(FileTypeIndex.NAME, QCFileType, GlobalSearchScope.projectScope(project))
        for (v in files) {
            scopes.add(psiManager.findFile(v))
        }
        return scopes
    }

    private fun find(processor: Processor<QCIdentifier>) {
        val scopes = getScopes()
        val all = ContainerUtil.newArrayList<QCIdentifier>()
        for (scope in scopes) {
            val identifiers = findScope(scope)
            all.addAll(identifiers)
            if (!ContainerUtil.process<QCIdentifier>(identifiers, processor)) {
                // No longer processing
                break
            }
        }
    }

    private fun findScope(parent: PsiElement): List<QCIdentifier> {
        return CachedValuesManager.getCachedValue<List<QCIdentifier>>(parent, object : CachedValueProvider<List<QCIdentifier>> {
            override fun compute(): CachedValueProvider.Result<List<QCIdentifier>>? {
                return CachedValueProvider.Result.create<List<QCIdentifier>>(computeImpl(), parent)
            }

            private fun computeImpl(): List<QCIdentifier> {
                val result = ContainerUtil.newArrayList<QCIdentifier>()
                parent.acceptChildren(object : PsiElementVisitor() {
                    override fun visitElement(element: PsiElement?) {
                        super.visitElement(element)
                        if (element is QCIdentifier) {
                            if (isDeclaration(element)) {
                                result.add(element)
                            }
                        }
                        if (!isBlockElement(element)) {
                            element!!.acceptChildren(this)
                        }
                    }
                })
                return result
            }
        })
    }

    override fun multiResolve(incompleteCode: Boolean) = resolveAll().map {
        PsiElementResolveResult(it)
    }.toTypedArray()

    private fun resolveAll(): Array<QCIdentifier> {
        val processor = CollectProcessor<QCIdentifier>()
        find(processor)
        return ArrayUtil.toObjectArray<QCIdentifier>(processor.getResults(), javaClass<QCIdentifier>())
    }

    override fun resolve(): PsiElement? {
        val processor = object : FindProcessor<QCIdentifier>() {
            override fun accept(o: QCIdentifier?): Boolean {
                if (o == null) return false
                val name = o.getName()
                var isVector = false
                o.getParent().accept(object : QCVisitor() {
                    override fun visitType(o: QCType) {
                        isVector = "vector" == o.getText()
                    }

                    override fun visitParameter(o: QCParameter) {
                        o.getType().accept(this)
                    }

                    override fun visitVariable(o: QCVariable) {
                        o.getParent().accept(this)
                    }

                    override fun visitVariableDeclaration(o: QCVariableDeclaration) {
                        o.getType().accept(this)
                    }
                })
                val isComponent = Comparing.equal(name + "_x", key) || Comparing.equal(name + "_y", key) || Comparing.equal(name + "_z", key)
                return Comparing.equal(name, key) || (isVector && isComponent)
            }
        }
        find(processor)
        return processor.getFoundValue()
    }

    override fun getVariants(): Array<QCIdentifier> {
        return resolveAll()
    }

    companion object {

        public fun create(identifier: QCIdentifier): PsiReferenceBase<PsiElement>? {
            if (isDeclaration(identifier)) {
                return null
            }
            return QCReference(identifier)
        }

        private fun isDeclaration(identifier: QCIdentifier): Boolean {
            val parent = identifier.getParent()
            return parent is QCMethod || parent is QCParameter || parent is QCVariable
        }
    }

}
