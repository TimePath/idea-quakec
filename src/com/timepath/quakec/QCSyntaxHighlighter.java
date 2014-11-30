package com.timepath.quakec;

import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.psi.tree.IElementType;
import com.timepath.quakec.flex._QCLexer;
import com.timepath.quakec.psi.QCTypes;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;
import static com.timepath.quakec.psi.QCTypes.*;

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
        return new FlexAdapter(new _QCLexer());
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType t) {
        if (t == COMMENT_BLOCK) {
            return BLOCK_COMMENT_KEYS;
        }
        if (t == ID) {
            return IDENTIFIER_KEYS;
        }
        if (t == KW_BREAK
                || t == KW_CASE
                || t == KW_CONTINUE
                || t == KW_DO
                || t == KW_ELSE
                || t == KW_FOR
                || t == KW_GOTO
                || t == KW_IF
                || t == KW_RETURN
                || t == KW_SWITCH
                || t == KW_WHILE) {
            return KEYWORD_KEYS;
        }
        if (t == COMMENT_LINE) {
            return LINE_COMMENT_KEYS;
        }
        if (t == MOD_CONST || t == MOD_VAR) {
            return MODIFIER_KEYS;
        }
        if (t == QCTypes.NUMBER) {
            return NUMBER_KEYS;
        }
        if (t == PREPROCESSOR) {
            return PREPROC_KEYS;
        }
        if (t == QCTypes.STRING) {
            return STRING_KEYS;
        }
        if (t == T_VOID
                || t == T_FLOAT
                || t == T_VECTOR
                || t == T_STRING
                || t == T_ENTITY
                ) {
            return TYPE_KEYS;
        }
        return EMPTY_KEYS;
    }
}
