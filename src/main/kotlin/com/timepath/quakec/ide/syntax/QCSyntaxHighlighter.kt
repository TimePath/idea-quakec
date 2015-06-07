package com.timepath.quakec.ide.syntax

import com.intellij.lang.LanguageParserDefinitions
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.psi.tree.IElementType
import com.timepath.quakec.ide.QCLanguage
import com.timepath.quakec.psi.QCTypes

public class QCSyntaxHighlighter : SyntaxHighlighterBase() {

    override fun getHighlightingLexer(): Lexer {
        return LanguageParserDefinitions.INSTANCE.forLanguage(QCLanguage).createLexer(null)
    }

    override fun getTokenHighlights(t: IElementType?): Array<TextAttributesKey> {
        if (t == QCTypes.TOKEN_COMMENT_BLOCK) {
            return BLOCK_COMMENT_KEYS
        }
        if (t == QCTypes.TOKEN_IDENTIFIER) {
            return IDENTIFIER_KEYS
        }
        when (t) {
            QCTypes.KW_BREAK,
            QCTypes.KW_CASE,
            QCTypes.KW_DEFAULT,
            QCTypes.KW_CONTINUE,
            QCTypes.KW_DO,
            QCTypes.KW_ELSE,
            QCTypes.KW_FOR,
            QCTypes.KW_GOTO,
            QCTypes.KW_IF,
            QCTypes.KW_RETURN,
            QCTypes.KW_SWITCH,
            QCTypes.KW_WHILE,
            QCTypes.KW_TYPEDEF,
            QCTypes.L_FALSE,
            QCTypes.L_TRUE
            -> {
                return KEYWORD_KEYS
            }
        }
        if (t == QCTypes.TOKEN_COMMENT_LINE) {
            return LINE_COMMENT_KEYS
        }
        if (t == QCTypes.MOD_CONST || t == QCTypes.MOD_VAR) {
            return MODIFIER_KEYS
        }
        if (t == QCTypes.TOKEN_NUMBER) {
            return NUMBER_KEYS
        }
        if (t == QCTypes.TOKEN_PREPROCESSOR) {
            return PREPROC_KEYS
        }
        if (t == QCTypes.TOKEN_STRING) {
            return STRING_KEYS
        }
        if (t == QCTypes.T_VOID || t == QCTypes.T_FLOAT || t == QCTypes.T_VECTOR || t == QCTypes.T_STRING || t == QCTypes.T_ENTITY || t == QCTypes.T_INT || t == QCTypes.T_BOOL) {
            return TYPE_KEYS
        }
        return EMPTY_KEYS
    }

    companion object {

        public val BLOCK_COMMENT: TextAttributesKey = createTextAttributesKey("BLOCK_COMMENT", DefaultLanguageHighlighterColors.BLOCK_COMMENT)
        public val IDENTIFIER: TextAttributesKey = createTextAttributesKey("IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER)
        public val KEYWORD: TextAttributesKey = createTextAttributesKey("KEYWORD", DefaultLanguageHighlighterColors.KEYWORD)
        public val LINE_COMMENT: TextAttributesKey = createTextAttributesKey("LINE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)
        public val MODIFIER: TextAttributesKey = createTextAttributesKey("MODIFIER", DefaultLanguageHighlighterColors.KEYWORD)
        public val NUMBER: TextAttributesKey = createTextAttributesKey("NUMBER", DefaultLanguageHighlighterColors.NUMBER)
        public val PREPROC: TextAttributesKey = createTextAttributesKey("PREPROC", DefaultLanguageHighlighterColors.METADATA)
        public val STRING: TextAttributesKey = createTextAttributesKey("STRING", DefaultLanguageHighlighterColors.STRING)
        public val TYPE: TextAttributesKey = createTextAttributesKey("KEYWORD", DefaultLanguageHighlighterColors.KEYWORD)

        private val BLOCK_COMMENT_KEYS = arrayOf(BLOCK_COMMENT)
        private val IDENTIFIER_KEYS = arrayOf(IDENTIFIER)
        private val KEYWORD_KEYS = arrayOf(KEYWORD)
        private val LINE_COMMENT_KEYS = arrayOf(LINE_COMMENT)
        private val MODIFIER_KEYS = arrayOf(MODIFIER)
        private val NUMBER_KEYS = arrayOf(NUMBER)
        private val PREPROC_KEYS = arrayOf(PREPROC)
        private val STRING_KEYS = arrayOf(STRING)
        private val TYPE_KEYS = arrayOf(TYPE)

        public val DESCRIPTORS: Array<AttributesDescriptor> = arrayOf(AttributesDescriptor("Block comment", BLOCK_COMMENT),
                AttributesDescriptor("Identifier", IDENTIFIER),
                AttributesDescriptor("Keyword", KEYWORD),
                AttributesDescriptor("Line comment", LINE_COMMENT),
                AttributesDescriptor("Modifier", MODIFIER),
                AttributesDescriptor("Number", NUMBER),
                AttributesDescriptor("Preprocessor", PREPROC),
                AttributesDescriptor("String", STRING),
                AttributesDescriptor("Type", TYPE)
        )

        private val EMPTY_KEYS = arrayOf<TextAttributesKey>()
    }
}
