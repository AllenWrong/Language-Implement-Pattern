package parser.example;

import Lexer.*;

/**
 * grammar NestedNameList:
 * list     : '[' elements ']';
 * elements : element (',' element)*;
 * element  : NAME '=' NAME
 *          | NAME
 *          | list;
 * NAME     : ('a'..'z'|'A'..'Z')+;
 *
 */
public class ComplexListLexer extends Lexer {

    public ComplexListLexer(String input) {
        super(input);
    }

    public boolean isLetter() {
        return 'z' >= c && 'a' <= c || 'A' <= c && 'Z' >= c;
    }

    public Token NAME() {
        StringBuilder builder = new StringBuilder();
        do {
            builder.append(c);
            consume();
        } while (isLetter());

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
                    WS();
                    break;
                case '[':
                    consume();
                    return new Token(TokenInfo.LBRACK, "[");
                case ']':
                    consume();
                    return new Token(TokenInfo.RBRACK, "]");
                case ',':
                    consume();
                    return new Token(TokenInfo.COMMA, ",");
                case '=':
                    consume();
                    return new Token(TokenInfo.EQUAL, "=");
                default:
                    if (isLetter()) {
                        return NAME();
                    } else {
                        throw new RuntimeException("Expected letter but not!");
                    }

            }
        }
        return new Token(TokenInfo.EOF, "<EOF>");
    }

    @Override
    public String getTokenName(int tokenType) {
        return null;
    }
}
