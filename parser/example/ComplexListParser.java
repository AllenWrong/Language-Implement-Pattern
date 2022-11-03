package parser.example;

import Lexer.*;
import parser.LLKParser;

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
public class ComplexListParser extends LLKParser {

    public ComplexListParser(ComplexListLexer input, int k) {
        super(input, k);
    }

    public void list() {
        match(TokenInfo.LBRACK);
        elements();
        match(TokenInfo.RBRACK);
    }

    public void elements() {
        element();
        while (lookahead[coming_pos].type == TokenInfo.COMMA) {
            match(TokenInfo.COMMA);
            element();
        }
    }

    public void element() {
        if (lookahead[coming_pos].type == TokenInfo.LBRACK) {
            list();
        } else if (lookaheadType(1) == TokenInfo.NAME) {
            if (lookaheadType(2) == TokenInfo.EQUAL) {
                match(TokenInfo.NAME);
                match(TokenInfo.EQUAL);
                match(TokenInfo.NAME);
            } else {
                match(TokenInfo.NAME);
            }
        } else {
            throw new RuntimeException("Unexpected token " + lookahead[coming_pos]);
        }
    }

}
