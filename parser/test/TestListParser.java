package parser.test;

import Lexer.example.ListLexer;
import parser.example.ComplexListLexer;
import parser.example.ComplexListParser;
import parser.example.ListParser;
import org.junit.Test;

public class TestListParser {

    @Test
    public void testSimpleList() {
        String input = "[a, b, e, f]";
        ListParser parser = new ListParser(new ListLexer(input));
        parser.list();
    }

    @Test
    public void testComplexList() {
        String input = "[a, b, [c, [d, e]]]";
        ListParser parser = new ListParser(new ListLexer(input));
        parser.list();
    }

    @Test
    public void testLL2List() {
        String input = "[a, b=c, [d, e]]";
        ComplexListParser parser = new ComplexListParser(new ComplexListLexer(input), 2);
        parser.list();
    }
}
