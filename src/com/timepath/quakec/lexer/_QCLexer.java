/* The following code was generated by JFlex 1.4.3 on 4/12/14 2:29 PM */

package com.timepath.quakec.lexer;
import com.intellij.lexer.*;
import com.intellij.psi.tree.IElementType;
import static com.timepath.quakec.psi.QCTypes.*;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 4/12/14 2:29 PM from the specification file
 * <tt>/home/andrew/IdeaProjects/QuakeCPlugin/src/com/timepath/quakec/lexer/_QCLexer.flex</tt>
 */
public class _QCLexer implements FlexLexer {
  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\1\1\2\1\3\1\1\1\1\22\0\1\1\1\52\1\36"+
    "\1\4\1\0\1\44\1\45\1\35\1\64\1\65\1\27\1\42\1\54"+
    "\1\43\1\34\1\26\1\30\11\33\1\56\1\55\1\50\1\41\1\51"+
    "\1\57\1\0\6\32\24\37\1\62\1\25\1\63\1\47\1\40\1\0"+
    "\1\17\1\71\1\12\1\5\1\6\1\7\1\21\1\73\1\10\1\37"+
    "\1\72\1\13\1\24\1\11\1\22\1\23\1\37\1\20\1\15\1\66"+
    "\1\14\1\70\1\16\1\31\1\67\1\37\1\60\1\46\1\61\1\53"+
    "\uff81\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\1\1\2\1\3\1\4\1\5\14\6\1\7\1\10"+
    "\2\1\1\11\2\2\1\1\1\12\1\13\1\14\1\15"+
    "\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25"+
    "\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35"+
    "\1\36\3\6\7\0\1\6\1\37\4\6\1\40\11\6"+
    "\1\41\1\0\1\42\1\43\1\0\1\1\3\0\1\44"+
    "\2\0\1\45\1\46\1\47\1\50\1\51\1\52\1\53"+
    "\1\54\1\55\1\56\1\57\1\60\1\61\1\62\1\63"+
    "\1\64\5\6\4\0\1\65\4\0\4\6\1\66\1\6"+
    "\1\67\10\6\1\0\1\1\1\70\1\71\1\72\2\6"+
    "\1\73\2\6\5\0\1\65\4\0\2\6\1\74\2\6"+
    "\1\75\7\6\1\76\1\77\2\6\1\100\1\6\5\0"+
    "\2\6\1\101\1\102\1\103\1\6\1\104\2\6\1\105"+
    "\3\6\1\106\3\0\1\6\1\107\1\6\1\110\1\111"+
    "\1\112\1\6\1\113\1\0\1\114\1\6\1\115\1\116";

  private static int [] zzUnpackAction() {
    int [] result = new int[203];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\74\0\170\0\264\0\360\0\u012c\0\u0168\0\u01a4"+
    "\0\u01e0\0\u021c\0\u0258\0\u0294\0\u02d0\0\u030c\0\u0348\0\u0384"+
    "\0\u03c0\0\u03fc\0\u0438\0\u0474\0\u04b0\0\u04ec\0\u0528\0\u0564"+
    "\0\u05a0\0\u05dc\0\u0618\0\u0654\0\u0690\0\u06cc\0\u0708\0\u0744"+
    "\0\u0780\0\u07bc\0\u07f8\0\74\0\74\0\74\0\74\0\74"+
    "\0\74\0\74\0\74\0\74\0\74\0\74\0\u0834\0\u0870"+
    "\0\u08ac\0\360\0\u08e8\0\u0924\0\u0960\0\u099c\0\u09d8\0\u0a14"+
    "\0\u0a50\0\u02d0\0\u0a8c\0\u0ac8\0\u0b04\0\u0b40\0\u02d0\0\u0b7c"+
    "\0\u0bb8\0\u0bf4\0\u0c30\0\u0c6c\0\u0ca8\0\u0ce4\0\u0d20\0\u0d5c"+
    "\0\u0d98\0\u0dd4\0\74\0\74\0\u0e10\0\u0e4c\0\u0e88\0\u0528"+
    "\0\u0ec4\0\74\0\u0564\0\u0f00\0\74\0\74\0\74\0\74"+
    "\0\74\0\74\0\74\0\74\0\74\0\74\0\74\0\74"+
    "\0\u0f3c\0\74\0\u0f78\0\74\0\u0fb4\0\u0ff0\0\u102c\0\u1068"+
    "\0\u10a4\0\u10e0\0\u111c\0\u1158\0\u1194\0\u11d0\0\u120c\0\u1248"+
    "\0\u1284\0\u12c0\0\u12fc\0\u1338\0\u1374\0\u13b0\0\u02d0\0\u13ec"+
    "\0\u02d0\0\u1428\0\u1464\0\u14a0\0\u14dc\0\u1518\0\u1554\0\u1590"+
    "\0\u15cc\0\u1608\0\u0e10\0\74\0\74\0\74\0\u1644\0\u1680"+
    "\0\u02d0\0\u16bc\0\u16f8\0\u1734\0\u1770\0\u17ac\0\u17e8\0\u1824"+
    "\0\u1860\0\u189c\0\u18d8\0\u1914\0\u1950\0\u198c\0\u19c8\0\u02d0"+
    "\0\u1a04\0\u1a40\0\u02d0\0\u1a7c\0\u1ab8\0\u1af4\0\u1b30\0\u1b6c"+
    "\0\u1ba8\0\u1be4\0\u02d0\0\74\0\u1c20\0\u1c5c\0\u02d0\0\u1c98"+
    "\0\u1cd4\0\u1d10\0\u1d4c\0\u1d88\0\u1dc4\0\u1e00\0\u1e3c\0\u02d0"+
    "\0\u02d0\0\u02d0\0\u1e78\0\u02d0\0\u1eb4\0\u1ef0\0\u02d0\0\u1f2c"+
    "\0\u1f68\0\u1fa4\0\u02d0\0\u1fe0\0\u201c\0\u2058\0\u2094\0\u02d0"+
    "\0\u20d0\0\u02d0\0\u02d0\0\u02d0\0\u210c\0\u02d0\0\u2148\0\u02d0"+
    "\0\u2184\0\u02d0\0\u02d0";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[203];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\2\3\1\4\1\5\1\6\1\7\1\10\1\11"+
    "\1\12\1\13\1\14\1\15\1\16\1\17\1\15\1\20"+
    "\1\21\3\15\1\2\1\22\1\23\1\24\2\15\1\25"+
    "\1\26\1\27\1\30\1\15\1\31\1\32\1\33\1\34"+
    "\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44"+
    "\1\45\1\46\1\47\1\50\1\51\1\52\1\53\1\54"+
    "\1\55\1\56\1\57\1\15\1\60\1\61\2\15\75\0"+
    "\2\3\1\4\71\0\3\4\71\0\3\62\1\0\1\63"+
    "\1\64\1\0\1\65\3\0\1\66\1\0\1\67\4\0"+
    "\1\70\55\0\1\15\1\71\13\15\1\72\2\15\3\0"+
    "\4\15\3\0\2\15\25\0\6\15\5\0\4\15\1\73"+
    "\1\15\1\74\11\15\3\0\4\15\3\0\2\15\25\0"+
    "\6\15\5\0\6\15\1\75\6\15\1\76\2\15\3\0"+
    "\4\15\3\0\2\15\25\0\6\15\5\0\2\15\1\77"+
    "\15\15\3\0\4\15\3\0\2\15\25\0\6\15\5\0"+
    "\15\15\1\100\2\15\3\0\4\15\3\0\2\15\25\0"+
    "\6\15\5\0\12\15\1\101\2\15\1\102\2\15\3\0"+
    "\4\15\3\0\2\15\25\0\6\15\5\0\15\15\1\103"+
    "\2\15\3\0\4\15\3\0\2\15\25\0\6\15\5\0"+
    "\20\15\3\0\4\15\3\0\2\15\25\0\6\15\5\0"+
    "\11\15\1\104\6\15\3\0\4\15\3\0\2\15\25\0"+
    "\1\105\5\15\5\0\20\15\3\0\4\15\3\0\2\15"+
    "\25\0\5\15\1\106\5\0\1\15\1\107\16\15\3\0"+
    "\4\15\3\0\2\15\25\0\6\15\5\0\15\15\1\110"+
    "\2\15\3\0\4\15\3\0\2\15\25\0\6\15\26\0"+
    "\1\111\1\112\11\0\1\113\73\0\1\114\62\0\1\25"+
    "\1\115\1\0\1\25\1\116\3\0\1\25\63\0\1\25"+
    "\2\0\1\25\1\116\3\0\1\25\63\0\1\116\2\0"+
    "\1\116\1\117\3\0\1\116\33\0\25\120\1\121\7\120"+
    "\1\122\36\120\25\123\1\124\10\123\1\122\35\123\5\0"+
    "\20\15\3\0\1\31\2\15\1\31\1\116\2\0\1\15"+
    "\1\31\25\0\6\15\41\0\1\125\73\0\1\126\1\127"+
    "\72\0\1\130\1\0\1\131\71\0\1\132\73\0\1\133"+
    "\3\0\1\134\67\0\1\135\4\0\1\136\66\0\1\137"+
    "\73\0\1\140\6\0\1\141\64\0\1\142\7\0\1\143"+
    "\63\0\1\144\37\0\20\15\3\0\4\15\3\0\2\15"+
    "\25\0\1\15\1\145\4\15\5\0\1\15\1\146\10\15"+
    "\1\147\2\15\1\150\2\15\3\0\4\15\3\0\2\15"+
    "\25\0\6\15\5\0\13\15\1\151\4\15\3\0\4\15"+
    "\3\0\2\15\25\0\6\15\6\0\1\152\76\0\1\153"+
    "\1\0\1\154\4\0\1\155\62\0\1\156\1\0\1\157"+
    "\73\0\1\160\101\0\1\161\74\0\1\162\60\0\2\15"+
    "\1\163\15\15\3\0\4\15\3\0\2\15\25\0\6\15"+
    "\5\0\20\15\3\0\4\15\3\0\2\15\25\0\1\164"+
    "\5\15\5\0\10\15\1\165\7\15\3\0\4\15\3\0"+
    "\2\15\25\0\6\15\5\0\15\15\1\166\2\15\3\0"+
    "\4\15\3\0\2\15\25\0\6\15\5\0\13\15\1\167"+
    "\4\15\3\0\4\15\3\0\2\15\25\0\6\15\5\0"+
    "\13\15\1\170\4\15\3\0\4\15\3\0\2\15\25\0"+
    "\1\171\5\15\5\0\10\15\1\172\7\15\3\0\4\15"+
    "\3\0\2\15\25\0\6\15\5\0\4\15\1\173\13\15"+
    "\3\0\4\15\3\0\2\15\25\0\6\15\5\0\5\15"+
    "\1\174\12\15\3\0\4\15\3\0\2\15\25\0\6\15"+
    "\5\0\3\15\1\175\14\15\3\0\4\15\3\0\2\15"+
    "\25\0\6\15\5\0\13\15\1\176\4\15\3\0\4\15"+
    "\3\0\2\15\25\0\6\15\5\0\3\15\1\177\14\15"+
    "\3\0\4\15\3\0\2\15\25\0\6\15\5\0\20\15"+
    "\3\0\4\15\3\0\2\15\25\0\1\200\5\15\5\0"+
    "\20\15\3\0\4\15\3\0\2\15\25\0\1\201\5\15"+
    "\2\111\1\0\71\111\27\112\1\202\44\112\5\0\3\203"+
    "\2\0\1\203\4\0\1\203\10\0\1\203\1\0\2\203"+
    "\4\0\1\203\30\0\1\203\32\0\1\116\2\0\1\116"+
    "\4\0\1\116\67\0\1\204\37\0\2\120\1\0\71\120"+
    "\2\123\1\0\71\123\41\0\1\205\73\0\1\206\37\0"+
    "\16\15\1\207\1\15\3\0\4\15\3\0\2\15\25\0"+
    "\6\15\5\0\5\15\1\210\12\15\3\0\4\15\3\0"+
    "\2\15\25\0\6\15\5\0\13\15\1\211\4\15\3\0"+
    "\4\15\3\0\2\15\25\0\6\15\5\0\3\15\1\212"+
    "\14\15\3\0\4\15\3\0\2\15\25\0\6\15\5\0"+
    "\1\15\1\213\16\15\3\0\4\15\3\0\2\15\25\0"+
    "\6\15\7\0\1\214\71\0\1\215\76\0\1\216\4\0"+
    "\1\217\76\0\1\220\53\0\2\156\1\0\22\156\1\221"+
    "\46\156\12\0\1\222\66\0\1\223\106\0\1\224\72\0"+
    "\1\225\61\0\12\15\1\226\5\15\3\0\4\15\3\0"+
    "\2\15\25\0\6\15\5\0\3\15\1\227\14\15\3\0"+
    "\4\15\3\0\2\15\25\0\6\15\5\0\1\15\1\230"+
    "\16\15\3\0\4\15\3\0\2\15\25\0\6\15\5\0"+
    "\12\15\1\231\5\15\3\0\4\15\3\0\2\15\25\0"+
    "\6\15\5\0\1\15\1\232\16\15\3\0\4\15\3\0"+
    "\2\15\25\0\6\15\5\0\1\15\1\233\16\15\3\0"+
    "\4\15\3\0\2\15\25\0\6\15\5\0\10\15\1\234"+
    "\7\15\3\0\4\15\3\0\2\15\25\0\1\235\5\15"+
    "\5\0\12\15\1\236\5\15\3\0\4\15\3\0\2\15"+
    "\25\0\6\15\5\0\20\15\3\0\4\15\3\0\2\15"+
    "\25\0\1\237\5\15\5\0\3\15\1\240\14\15\3\0"+
    "\4\15\3\0\2\15\25\0\6\15\5\0\6\15\1\241"+
    "\11\15\3\0\4\15\3\0\2\15\25\0\6\15\5\0"+
    "\7\15\1\242\10\15\3\0\4\15\3\0\2\15\25\0"+
    "\6\15\5\0\15\15\1\243\2\15\3\0\4\15\3\0"+
    "\2\15\25\0\6\15\26\112\1\244\1\202\44\112\5\0"+
    "\1\15\1\245\16\15\3\0\4\15\3\0\2\15\25\0"+
    "\6\15\5\0\20\15\3\0\4\15\3\0\2\15\25\0"+
    "\1\246\5\15\5\0\1\247\17\15\3\0\4\15\3\0"+
    "\2\15\25\0\6\15\5\0\12\15\1\250\5\15\3\0"+
    "\4\15\3\0\2\15\25\0\6\15\10\0\1\251\73\0"+
    "\1\216\72\0\1\156\72\0\1\156\107\0\1\252\51\0"+
    "\1\156\3\221\21\156\1\221\46\156\13\0\1\253\66\0"+
    "\1\216\76\0\1\254\103\0\1\255\57\0\7\15\1\256"+
    "\10\15\3\0\4\15\3\0\2\15\25\0\6\15\5\0"+
    "\20\15\3\0\4\15\3\0\2\15\25\0\1\257\5\15"+
    "\5\0\20\15\3\0\4\15\3\0\2\15\25\0\1\260"+
    "\5\15\5\0\2\15\1\261\15\15\3\0\4\15\3\0"+
    "\2\15\25\0\6\15\5\0\20\15\3\0\4\15\3\0"+
    "\2\15\25\0\1\262\5\15\5\0\3\15\1\263\14\15"+
    "\3\0\4\15\3\0\2\15\25\0\6\15\5\0\6\15"+
    "\1\264\11\15\3\0\4\15\3\0\2\15\25\0\6\15"+
    "\5\0\5\15\1\265\12\15\3\0\4\15\3\0\2\15"+
    "\25\0\6\15\5\0\4\15\1\266\13\15\3\0\4\15"+
    "\3\0\2\15\25\0\6\15\5\0\1\15\1\267\16\15"+
    "\3\0\4\15\3\0\2\15\25\0\6\15\5\0\13\15"+
    "\1\270\4\15\3\0\4\15\3\0\2\15\25\0\6\15"+
    "\5\0\1\271\17\15\3\0\4\15\3\0\2\15\25\0"+
    "\6\15\5\0\15\15\1\272\2\15\3\0\4\15\3\0"+
    "\2\15\25\0\6\15\5\0\20\15\3\0\4\15\3\0"+
    "\2\15\25\0\4\15\1\273\1\15\11\0\1\217\102\0"+
    "\1\156\67\0\1\274\67\0\1\275\107\0\1\276\54\0"+
    "\6\15\1\277\11\15\3\0\4\15\3\0\2\15\25\0"+
    "\6\15\5\0\20\15\3\0\4\15\3\0\2\15\25\0"+
    "\1\15\1\300\4\15\5\0\4\15\1\301\13\15\3\0"+
    "\4\15\3\0\2\15\25\0\6\15\5\0\20\15\3\0"+
    "\4\15\3\0\2\15\25\0\5\15\1\302\5\0\14\15"+
    "\1\303\3\15\3\0\4\15\3\0\2\15\25\0\6\15"+
    "\5\0\4\15\1\304\13\15\3\0\4\15\3\0\2\15"+
    "\25\0\6\15\5\0\1\15\1\305\16\15\3\0\4\15"+
    "\3\0\2\15\25\0\6\15\5\0\13\15\1\306\4\15"+
    "\3\0\4\15\3\0\2\15\25\0\6\15\5\0\1\217"+
    "\77\0\1\307\101\0\1\156\61\0\20\15\3\0\4\15"+
    "\3\0\2\15\25\0\1\310\5\15\5\0\7\15\1\311"+
    "\10\15\3\0\4\15\3\0\2\15\25\0\6\15\5\0"+
    "\2\15\1\312\15\15\3\0\4\15\3\0\2\15\25\0"+
    "\6\15\21\0\1\156\57\0\1\15\1\313\16\15\3\0"+
    "\4\15\3\0\2\15\25\0\6\15";

  private static int [] zzUnpackTrans() {
    int [] result = new int[8640];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;
  private static final char[] EMPTY_BUFFER = new char[0];
  private static final int YYEOF = -1;
  private static java.io.Reader zzReader = null; // Fake

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\1\1\11\41\1\13\11\3\1\7\0\21\1\1\0"+
    "\2\11\1\0\1\1\3\0\1\11\2\0\14\11\1\1"+
    "\1\11\1\1\1\11\5\1\4\0\1\1\4\0\17\1"+
    "\1\0\1\1\3\11\5\1\5\0\1\1\4\0\16\1"+
    "\1\11\4\1\5\0\16\1\3\0\10\1\1\0\4\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[203];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** this buffer may contains the current text array to be matched when it is cheap to acquire it */
  private char[] zzBufferArray;

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the textposition at the last state to be included in yytext */
  private int zzPushbackPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /* user code: */
  public _QCLexer() {
    this((java.io.Reader)null);
  }


  public _QCLexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public _QCLexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 142) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public final int getTokenStart(){
    return zzStartRead;
  }

  public final int getTokenEnd(){
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end,int initialState){
    zzBuffer = buffer;
    zzBufferArray = com.intellij.util.text.CharArrayUtil.fromSequenceWithoutCopying(buffer);
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzPushbackPos = 0;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position <tt>pos</tt> from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBufferArray != null ? zzBufferArray[zzStartRead+pos]:zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;
    char[] zzBufferArrayL = zzBufferArray;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL)
            zzInput = (zzBufferArrayL != null ? zzBufferArrayL[zzCurrentPosL++] : zzBufferL.charAt(zzCurrentPosL++));
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = (zzBufferArrayL != null ? zzBufferArrayL[zzCurrentPosL++] : zzBufferL.charAt(zzCurrentPosL++));
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 56: 
          { return T_ARGS;
          }
        case 79: break;
        case 19: 
          { return OP_NOT_LOGIC;
          }
        case 80: break;
        case 39: 
          { return OP_INC;
          }
        case 81: break;
        case 4: 
          { return TOKEN_SPACE;
          }
        case 82: break;
        case 50: 
          { return OP_GE;
          }
        case 83: break;
        case 24: 
          { return QUESTION;
          }
        case 84: break;
        case 10: 
          { return OP_ASSIGN;
          }
        case 85: break;
        case 13: 
          { return OP_MODULO;
          }
        case 86: break;
        case 9: 
          { return OP_DOT;
          }
        case 87: break;
        case 23: 
          { return COLON;
          }
        case 88: break;
        case 49: 
          { return OP_LSH;
          }
        case 89: break;
        case 37: 
          { return OP_EQ;
          }
        case 90: break;
        case 28: 
          { return INDEX_CLOSE;
          }
        case 91: break;
        case 66: 
          { return MOD_NOREF;
          }
        case 92: break;
        case 1: 
          { return TOKEN_NUMBER;
          }
        case 93: break;
        case 76: 
          { return KW_DEFAULT;
          }
        case 94: break;
        case 44: 
          { return OP_AND_LOGIC;
          }
        case 95: break;
        case 55: 
          { return KW_NOT;
          }
        case 96: break;
        case 41: 
          { return OP_SUB;
          }
        case 97: break;
        case 73: 
          { return T_STRING;
          }
        case 98: break;
        case 3: 
          { return com.intellij.psi.TokenType.WHITE_SPACE;
          }
        case 99: break;
        case 51: 
          { return OP_RSH;
          }
        case 100: break;
        case 12: 
          { return OP_MINUS;
          }
        case 101: break;
        case 54: 
          { return KW_FOR;
          }
        case 102: break;
        case 71: 
          { return T_ENTITY;
          }
        case 103: break;
        case 64: 
          { return T_VOID;
          }
        case 104: break;
        case 20: 
          { return OP_NOT;
          }
        case 105: break;
        case 11: 
          { return OP_PLUS;
          }
        case 106: break;
        case 35: 
          { return OP_MULA;
          }
        case 107: break;
        case 45: 
          { return OP_ORA;
          }
        case 108: break;
        case 27: 
          { return INDEX_OPEN;
          }
        case 109: break;
        case 65: 
          { return T_FLOAT;
          }
        case 110: break;
        case 6: 
          { return TOKEN_IDENTIFIER;
          }
        case 111: break;
        case 34: 
          { return OP_DIVA;
          }
        case 112: break;
        case 38: 
          { return OP_ADDA;
          }
        case 113: break;
        case 17: 
          { return OP_LT;
          }
        case 114: break;
        case 30: 
          { return PAREN_CLOSE;
          }
        case 115: break;
        case 42: 
          { return OP_MODA;
          }
        case 116: break;
        case 78: 
          { return KW_CONTINUE;
          }
        case 117: break;
        case 5: 
          { return HASH;
          }
        case 118: break;
        case 58: 
          { return OP_RSHA;
          }
        case 119: break;
        case 22: 
          { return SEMI;
          }
        case 120: break;
        case 63: 
          { return TOKEN_COMMENT_BLOCK;
          }
        case 121: break;
        case 31: 
          { return KW_DO;
          }
        case 122: break;
        case 40: 
          { return OP_SUBA;
          }
        case 123: break;
        case 8: 
          { return OP_MULTIPLY;
          }
        case 124: break;
        case 59: 
          { return MOD_VAR;
          }
        case 125: break;
        case 18: 
          { return OP_GT;
          }
        case 126: break;
        case 60: 
          { return KW_ELSE;
          }
        case 127: break;
        case 68: 
          { return MOD_LOCAL;
          }
        case 128: break;
        case 57: 
          { return OP_LSHA;
          }
        case 129: break;
        case 67: 
          { return MOD_CONST;
          }
        case 130: break;
        case 14: 
          { return OP_AND;
          }
        case 131: break;
        case 62: 
          { return KW_GOTO;
          }
        case 132: break;
        case 26: 
          { return BRACE_CLOSE;
          }
        case 133: break;
        case 15: 
          { return OP_OR;
          }
        case 134: break;
        case 75: 
          { return T_VECTOR;
          }
        case 135: break;
        case 29: 
          { return PAREN_OPEN;
          }
        case 136: break;
        case 43: 
          { return OP_ANDA;
          }
        case 137: break;
        case 61: 
          { return KW_CASE;
          }
        case 138: break;
        case 25: 
          { return BRACE_OPEN;
          }
        case 139: break;
        case 21: 
          { return OP_COMMA;
          }
        case 140: break;
        case 74: 
          { return KW_RETURN;
          }
        case 141: break;
        case 52: 
          { return OP_NE;
          }
        case 142: break;
        case 53: 
          { return TOKEN_PREPROCESSOR;
          }
        case 143: break;
        case 46: 
          { return OP_OR_LOGIC;
          }
        case 144: break;
        case 32: 
          { return KW_IF;
          }
        case 145: break;
        case 2: 
          { return com.intellij.psi.TokenType.BAD_CHARACTER;
          }
        case 146: break;
        case 48: 
          { return OP_LE;
          }
        case 147: break;
        case 72: 
          { return KW_SWITCH;
          }
        case 148: break;
        case 36: 
          { return TOKEN_STRING;
          }
        case 149: break;
        case 69: 
          { return KW_WHILE;
          }
        case 150: break;
        case 33: 
          { return TOKEN_COMMENT_LINE;
          }
        case 151: break;
        case 16: 
          { return OP_XOR;
          }
        case 152: break;
        case 7: 
          { return OP_DIVIDE;
          }
        case 153: break;
        case 47: 
          { return OP_XORA;
          }
        case 154: break;
        case 70: 
          { return KW_BREAK;
          }
        case 155: break;
        case 77: 
          { return KW_TYPEDEF;
          }
        case 156: break;
        default:
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            return null;
          }
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
