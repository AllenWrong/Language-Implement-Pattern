package parser;

import Lexer.*;
import parser.example.ComplexListLexer;

public class LLKParser {

    protected final Token[] lookahead;
    private final int k;
    /** 使用coming_pos比p更容易理解，它不是cur_pos */
    protected int coming_pos;
    protected ComplexListLexer input;

    public LLKParser(ComplexListLexer input, int k) {
        this.input = input;
        this.k = k;
        lookahead = new Token[k];

        for (int i = 0; i < k; i++) {
            consume();
        }
    }

    public void match(int x) {
        if (lookahead[coming_pos].type == x) {
            consume();
        } else {
            throw new RuntimeException("Expected type " + x + " but got " + lookahead[coming_pos].type);
        }
    }

    public void consume() {
        // 上一个位置放入新的词法单元
        lookahead[coming_pos] = input.nextToken();
        // 位置移动
        coming_pos = (coming_pos + 1) % k;
    }

    public Token lookaheadToken(int i) {
        return lookahead[(coming_pos + i - 1 ) % k];
    }

    public int lookaheadType(int i) {
        return lookaheadToken(i).type;
    }
}
