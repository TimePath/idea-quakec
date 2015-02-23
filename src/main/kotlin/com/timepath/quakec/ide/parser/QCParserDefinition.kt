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

/**
 * @author TimePath
 */
public class QCParserDefinition : ParserDefinition {

    override fun createLexer(project: Project) = FlexAdapter(_QCLexer())

    override fun createParser(project: Project) = QCParser()

    override fun getFileNodeType() = FILE

    override fun getWhitespaceTokens() = WHITE_SPACES

    override fun getCommentTokens() = COMMENTS

    override fun getStringLiteralElements() = STRINGS

    override fun createElement(node: ASTNode) = QCTypes.Factory.createElement(node)

    override fun createFile(viewProvider: FileViewProvider) = QCFile(viewProvider)

    override fun spaceExistanceTypeBetweenTokens(left: ASTNode, right: ASTNode) = ParserDefinition.SpaceRequirements.MAY

    class object {
        public val WHITE_SPACES: TokenSet = TokenSet.create(TokenType.WHITE_SPACE)
        public val COMMENTS: TokenSet = TokenSet.create(QCTypes.TOKEN_COMMENT_LINE, QCTypes.TOKEN_COMMENT_BLOCK)
        public val STRINGS: TokenSet = TokenSet.create(QCTypes.TOKEN_STRING)

        public val FILE: IFileElementType = IFileElementType(QCLanguage)
    }

}
