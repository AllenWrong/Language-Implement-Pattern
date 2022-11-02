package Lexer;

public class TokenInfo {
    public static String[] tokenNames = {
            "n/a", "EOF", "NAME", "COMMA", "LBRACK", "RBRACK"
    };

    public static final int EOF = 1;
    public static final int NAME = 2;
    public static final int COMMA = 3;
    public static final int LBRACK = 4;
    public static final int RBRACK = 5;
}
