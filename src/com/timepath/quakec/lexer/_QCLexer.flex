package com.timepath.quakec.lexer;
import com.intellij.lexer.*;
import com.intellij.psi.tree.IElementType;
import static com.timepath.quakec.psi.QCTypes.*;

%%

%{
  public _QCLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _QCLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL="\r"|"\n"|"\r\n"
LINE_WS=[\ \t\f]
WHITE_SPACE=({LINE_WS}|{EOL})+

SPACE=[ \t\n\x0B\f\r]+
PREPROCESSOR=#[ \t\n\x0B\f\r]*(define|include|(un|ifn?)def|endif|el(if|se)|if|warning|error|pragma)(.*\\[ \t\n\x0B\f\r]*\n)*.*
COMMENT_LINE="//".*
COMMENT_BLOCK=[\/][*](([^*]+|[*]+[^\/*])*[*]*)[*][\/]
NUMBER=0x[_0-9a-fA-F]+|[_0-9]*(\.[_0-9]*)?
STRING=('([^'\\]|\\.)*'|\"([^\"\\]|\\.)*\")
ID=[a-zA-Z_][a-zA-Z_0-9]*

%%
<YYINITIAL> {
  {WHITE_SPACE}        { return com.intellij.psi.TokenType.WHITE_SPACE; }

  "="                  { return OP_ASSIGN; }
  "+="                 { return OP_ADDA; }
  "-="                 { return OP_SUBA; }
  "*="                 { return OP_MULA; }
  "/="                 { return OP_DIVA; }
  "%="                 { return OP_MODA; }
  "&="                 { return OP_ANDA; }
  "|="                 { return OP_ORA; }
  "^="                 { return OP_XORA; }
  "<<="                { return OP_LSHA; }
  ">>="                { return OP_RSHA; }
  "||"                 { return OP_OR_LOGIC; }
  "&&"                 { return OP_AND_LOGIC; }
  "!"                  { return OP_NOT_LOGIC; }
  "|"                  { return OP_OR; }
  "^"                  { return OP_XOR; }
  "&"                  { return OP_AND; }
  "~"                  { return OP_NOT; }
  "=="                 { return OP_EQ; }
  "!="                 { return OP_NE; }
  "<"                  { return OP_LT; }
  "<="                 { return OP_LE; }
  ">"                  { return OP_GT; }
  ">="                 { return OP_GE; }
  "<<"                 { return OP_LSH; }
  ">>"                 { return OP_RSH; }
  "+"                  { return OP_PLUS; }
  "-"                  { return OP_MINUS; }
  "*"                  { return OP_MULTIPLY; }
  "/"                  { return OP_DIVIDE; }
  "%"                  { return OP_MODULO; }
  "++"                 { return OP_INC; }
  "--"                 { return OP_SUB; }
  ","                  { return OP_COMMA; }
  "."                  { return OP_DOT; }
  ";"                  { return SEMI; }
  ":"                  { return COLON; }
  "?"                  { return QUESTION; }
  "#"                  { return HASH; }
  "{"                  { return BRACE_OPEN; }
  "}"                  { return BRACE_CLOSE; }
  "["                  { return INDEX_OPEN; }
  "]"                  { return INDEX_CLOSE; }
  "("                  { return PAREN_OPEN; }
  ")"                  { return PAREN_CLOSE; }
  "entity"             { return T_ENTITY; }
  "string"             { return T_STRING; }
  "vector"             { return T_VECTOR; }
  "float"              { return T_FLOAT; }
  "void"               { return T_VOID; }
  "..."                { return T_ARGS; }
  "local"              { return MOD_LOCAL; }
  "const"              { return MOD_CONST; }
  "var"                { return MOD_VAR; }
  "noref"              { return MOD_NOREF; }
  "continue"           { return KW_CONTINUE; }
  "break"              { return KW_BREAK; }
  "goto"               { return KW_GOTO; }
  "return"             { return KW_RETURN; }
  "if"                 { return KW_IF; }
  "not"                { return KW_NOT; }
  "else"               { return KW_ELSE; }
  "while"              { return KW_WHILE; }
  "do"                 { return KW_DO; }
  "for"                { return KW_FOR; }
  "switch"             { return KW_SWITCH; }
  "case"               { return KW_CASE; }
  "default"            { return KS_DEFAULT; }
  "typedef"            { return KS_TYPEDEF; }

  {SPACE}              { return SPACE; }
  {PREPROCESSOR}       { return PREPROCESSOR; }
  {COMMENT_LINE}       { return COMMENT_LINE; }
  {COMMENT_BLOCK}      { return COMMENT_BLOCK; }
  {NUMBER}             { return NUMBER; }
  {STRING}             { return STRING; }
  {ID}                 { return ID; }

  [^] { return com.intellij.psi.TokenType.BAD_CHARACTER; }
}
