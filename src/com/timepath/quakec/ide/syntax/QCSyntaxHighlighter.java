package com.timepath.quakec.ide.syntax;

import com.intellij.lang.LanguageParserDefinitions;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.psi.tree.IElementType;
import com.timepath.quakec.ide.QCLanguage;
import com.timepath.quakec.psi.QCTypes;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

/**
 * @author TimePath
 */
public class QCSyntaxHighlighter extends SyntaxHighlighterBase {

    public static final TextAttributesKey BLOCK_COMMENT = createTextAttributesKey("BLOCK_COMMENT", DefaultLanguageHighlighterColors.BLOCK_COMMENT);
    public static final TextAttributesKey IDENTIFIER = createTextAttributesKey("IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER);
    public static final TextAttributesKey KEYWORD = createTextAttributesKey("KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey LINE_COMMENT = createTextAttributesKey("LINE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey MODIFIER = createTextAttributesKey("MODIFIER", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey NUMBER = createTextAttributesKey("NUMBER", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey PREPROC = createTextAttributesKey("PREPROC", DefaultLanguageHighlighterColors.METADATA);
    public static final TextAttributesKey STRING = createTextAttributesKey("STRING", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey TYPE = createTextAttributesKey("KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);

    private static final TextAttributesKey[] BLOCK_COMMENT_KEYS = new TextAttributesKey[]{BLOCK_COMMENT};
    private static final TextAttributesKey[] IDENTIFIER_KEYS = new TextAttributesKey[]{IDENTIFIER};
    private static final TextAttributesKey[] KEYWORD_KEYS = new TextAttributesKey[]{KEYWORD};
    private static final TextAttributesKey[] LINE_COMMENT_KEYS = new TextAttributesKey[]{LINE_COMMENT};
    private static final TextAttributesKey[] MODIFIER_KEYS = new TextAttributesKey[]{MODIFIER};
    private static final TextAttributesKey[] NUMBER_KEYS = new TextAttributesKey[]{NUMBER};
    private static final TextAttributesKey[] PREPROC_KEYS = new TextAttributesKey[]{PREPROC};
    private static final TextAttributesKey[] STRING_KEYS = new TextAttributesKey[]{STRING};
    private static final TextAttributesKey[] TYPE_KEYS = new TextAttributesKey[]{TYPE};

    public static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("Block comment", BLOCK_COMMENT),
            new AttributesDescriptor("Identifier", IDENTIFIER),
            new AttributesDescriptor("Keyword", KEYWORD),
            new AttributesDescriptor("Line comment", LINE_COMMENT),
            new AttributesDescriptor("Modifier", MODIFIER),
            new AttributesDescriptor("Number", NUMBER),
            new AttributesDescriptor("Preprocessor", PREPROC),
            new AttributesDescriptor("String", STRING),
            new AttributesDescriptor("Type", TYPE),
    };

    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return LanguageParserDefinitions.INSTANCE.forLanguage(QCLanguage.INSTANCE).createLexer(null);
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType t) {
        if (t == QCTypes.TOKEN_COMMENT_BLOCK) {
            return BLOCK_COMMENT_KEYS;
        }
        if (t == QCTypes.TOKEN_IDENTIFIER) {
            return IDENTIFIER_KEYS;
        }
        if (t == QCTypes.KW_BREAK
                || t == QCTypes.KW_CASE
                || t == QCTypes.KW_DEFAULT
                || t == QCTypes.KW_CONTINUE
                || t == QCTypes.KW_DO
                || t == QCTypes.KW_ELSE
                || t == QCTypes.KW_FOR
                || t == QCTypes.KW_GOTO
                || t == QCTypes.KW_IF
                || t == QCTypes.KW_RETURN
                || t == QCTypes.KW_SWITCH
                || t == QCTypes.KW_WHILE
                || t == QCTypes.KW_TYPEDEF) {
            return KEYWORD_KEYS;
        }
        if (t == QCTypes.TOKEN_COMMENT_LINE) {
            return LINE_COMMENT_KEYS;
        }
        if (t == QCTypes.MOD_CONST || t == QCTypes.MOD_VAR) {
            return MODIFIER_KEYS;
        }
        if (t == QCTypes.TOKEN_NUMBER) {
            return NUMBER_KEYS;
        }
        if (t == QCTypes.TOKEN_PREPROCESSOR) {
            return PREPROC_KEYS;
        }
        if (t == QCTypes.TOKEN_STRING) {
            return STRING_KEYS;
        }
        if (t == QCTypes.T_VOID
                || t == QCTypes.T_FLOAT
                || t == QCTypes.T_VECTOR
                || t == QCTypes.T_STRING
                || t == QCTypes.T_ENTITY
                ) {
            return TYPE_KEYS;
        }
        return EMPTY_KEYS;
    }
}
