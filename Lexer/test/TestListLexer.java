package Lexer.test;

import Lexer.Lexer;
import Lexer.example.ListLexer;
import org.junit.Test;

public class TestListLexer {
    @Test
    public void testLexer() {
        String input = "[a, b, [e, f]]";
        ListLexer lexer = new ListLexer(input);
        while (lexer.c != Lexer.EOF) {
            System.out.println(lexer.nextToken());
        }
    }
}
