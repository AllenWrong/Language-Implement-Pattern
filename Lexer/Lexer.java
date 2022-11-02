package Lexer;

public abstract class Lexer {
    public static final char EOF = (char)-1;
    public static final int EOF_TYPE = 1;
    /** 当前字符 */
    public char c;
    /** 当前字符的下标 */
    public int p;
    /** 输入的文本 */
    public String input;

    public Lexer(String input) {
        this.input = input;
        p = 0;
        c = input.charAt(p);
    }

    /**
     * 读取一个字符
     */
    public void consume() {
        p++;
        if (p >= input.length()) {
            c = EOF;
        } else {
            c = input.charAt(p);
        }
    }

    /**
     * 匹配当前字符是否是所需要的字符
     * @param x 所需要的字符
     */
    public void match(char x) {
        if (c == x) {
            consume();
        } else {
            throw new RuntimeException("Expect character '" + x + "' but found '" + c + "'");
        }
    }

    public abstract Token nextToken();
    public abstract String getTokenName(int tokenType);
}
