package parser;

import Lexer.Token;
import Lexer.Lexer;

public abstract class Parser {
    public final Lexer input;
    public Token lookahead;

    public Parser(Lexer input) {
        this.input = input;
        consume();
    }

    public void consume() {
        lookahead = input.nextToken();
    }

    public void match(int x) {
        if (lookahead.type == x) {
            consume();
        } else {
            throw new RuntimeException("Expected " + x + ", but got " + lookahead.type);
        }
    }

}
