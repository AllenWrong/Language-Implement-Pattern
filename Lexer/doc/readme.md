## Lexer基本组成成分

词法解析器的任务就是输出词法单元序列。每个词法单元序列都有两个基本的组成成分：词法类型和内容。比如：词法类型是COMMA，词法内容是‘,’。为了解析词法单元，词法解析器需要逐个读取字符，因此需要有一个负责移动字符的方法。在词法解析器中，要为每个词法单元定义一个同名的方法。。为了输出词法单元序列，因此词法解析器该应该暴露出来获取词法的方法。下面是伪代码：

```java
class Lexer {
    private char cur_ch;
    private char pos_on;
    
    /** 移动一个字符 */
    public void consume();
    
    /** 解析词法单元T */
    public void T();
    
    /** 其他的词法单元解析函数 */
    ...
    
    /** 获取一个token */
    public Token nextToken();
}
```

