package Lexer.example;

import Lexer.Lexer;
import Lexer.Token;
import Lexer.TokenInfo;

/**
 * grammar NestedNameList:
 * list     : '[' elements ']';
 * elements : element, (, element)*;
 * element  : NAME, list;
 * NAME     : ('a'..'z'|'A'..'Z')+;
 *
 */
public class ListLexer extends Lexer {

    public ListLexer(String input) {
        super(input);
    }

    public boolean isLetter() {
        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
    }

    /**
     * 解析Name
     * NAME     : ('a'..'z'|'A'..'Z')+;
     * @return token
     */
    public Token NAME() {
        StringBuilder builder = new StringBuilder();
        do {
            builder.append(c);
            consume();
        } while(isLetter());
        return new Token(TokenInfo.NAME, builder.toString());
    }

    /**
     * WS  : (' '|'\t'|'\n'|'\r')*
     * 忽略所有空白字符
     */
    public void WS() {
        while (c == ' ' || c == '\t' || c == '\n' || c == '\r') {
            consume();
        }
    }

    @Override
    public Token nextToken() {
        while (c != EOF) {
            switch (c) {
                case ' ': case '\t': case '\n': case '\r':
                    WS(); continue;
                case ',':
                    consume();
                    return new Token(TokenInfo.COMMA, ",");
                case '[':
                    consume();
                    return new Token(TokenInfo.LBRACK, "[");
                case ']':
                    consume();
                    return new Token(TokenInfo.RBRACK, "]");
                default:
                    if (isLetter()) {
                        return NAME();
                    } else {
                        throw new RuntimeException("invalid character '"+ c +"'");
                    }
            }
        }
        return new Token(EOF_TYPE, "<EOF>");
    }

    @Override
    public String getTokenName(int tokenType) {
        return TokenInfo.tokenNames[tokenType];
    }
}
