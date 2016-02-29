package com.timepath.quakec.ide.parser

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lexer.FlexAdapter
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import com.timepath.quakec.ide.QCLanguage
import com.timepath.quakec.lexer._QCLexer
import com.timepath.quakec.parser.QCParser
import com.timepath.quakec.psi.QCFile
import com.timepath.quakec.psi.QCTypes

class QCParserDefinition : ParserDefinition {

    override fun createLexer(project: Project?) = FlexAdapter(_QCLexer())

    override fun createParser(project: Project) = QCParser()

    private val fileNodeType = IFileElementType(QCLanguage)

    override fun getFileNodeType() = fileNodeType

    override fun getWhitespaceTokens() = TokenSet.create(TokenType.WHITE_SPACE)

    override fun getCommentTokens() = TokenSet.create(QCTypes.TOKEN_COMMENT_LINE, QCTypes.TOKEN_COMMENT_BLOCK)

    override fun getStringLiteralElements() = TokenSet.create(QCTypes.TOKEN_STRING)

    override fun createElement(node: ASTNode) = QCTypes.Factory.createElement(node)

    override fun createFile(viewProvider: FileViewProvider) = QCFile(viewProvider)

    override fun spaceExistanceTypeBetweenTokens(left: ASTNode, right: ASTNode) = ParserDefinition.SpaceRequirements.MAY

}
