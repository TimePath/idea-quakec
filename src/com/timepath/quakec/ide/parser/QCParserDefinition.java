package com.timepath.quakec.ide.parser;

import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import com.timepath.quakec.ide.QCLanguage;
import com.timepath.quakec.lexer._QCLexer;
import com.timepath.quakec.parser.QCParser;
import com.timepath.quakec.psi.QCFile;
import com.timepath.quakec.psi.QCTypes;
import org.jetbrains.annotations.NotNull;

/**
 * @author TimePath
 */
public class QCParserDefinition implements ParserDefinition {
    public static final TokenSet WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE);
    public static final TokenSet COMMENTS = TokenSet.create(QCTypes.COMMENT);
    public static final TokenSet STRINGS = TokenSet.create(QCTypes.TOKEN_STRING);

    public static final IFileElementType FILE = new IFileElementType(QCLanguage.INSTANCE);

    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new FlexAdapter(new _QCLexer());
    }

    @NotNull
    public PsiParser createParser(final Project project) {
        return new QCParser();
    }

    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    @NotNull
    public TokenSet getWhitespaceTokens() {
        return WHITE_SPACES;
    }

    @NotNull
    public TokenSet getCommentTokens() {
        return COMMENTS;
    }

    @NotNull
    public TokenSet getStringLiteralElements() {
        return STRINGS;
    }

    @NotNull
    public PsiElement createElement(ASTNode node) {
        return QCTypes.Factory.createElement(node);
    }

    public PsiFile createFile(FileViewProvider viewProvider) {
        return new QCFile(viewProvider);
    }

    public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode left, ASTNode right) {
        return SpaceRequirements.MAY;
    }

}
