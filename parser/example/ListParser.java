package parser.example;

import Lexer.Lexer;
import parser.Parser;
import Lexer.TokenInfo;

/**
 * grammar NestedNameList:
 * list     : '[' elements ']';
 * elements : element, (, element)*;
 * element  : NAME, list;
 * NAME     : ('a'..'z'|'A'..'Z')+;
 *
 */
public class ListParser extends Parser {

    public ListParser(Lexer input) {
        super(input);
    }

    /**
     * 解析一个列表
     */
    public void list() {
        match(TokenInfo.LBRACK);
        elements();
        match(TokenInfo.RBRACK);
    }

    /**
     * 解析elements
     */
    public void elements() {
        element();
        while (this.lookahead.type == TokenInfo.COMMA) {
            match(TokenInfo.COMMA);
            element();
        }
    }

    /**
     * 解析element <br/>
     * element  : NAME, list;
     * NAME     : ('a'..'z'|'A'..'Z')+;
     */
    public void element() {
        if (lookahead.type == TokenInfo.NAME) {
            match(TokenInfo.NAME);
        } else if (lookahead.type == TokenInfo.LBRACK) {
            list();
        } else {
            throw new RuntimeException("Expect NAME but found " + lookahead.type);
        }
    }

}
