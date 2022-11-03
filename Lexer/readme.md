## 递归下降识别器

这里描述了文法的递归下降识别器的简单结构。

- **文法：**定义了编程语言的词法和语法规则。具体而言，文法就是规则的集合。如果将文法定义成一个类的话，那么每条规则都要有一个对应的解析方法。
- **规则：**定义了字符如何组成词元（词法单元），词元如何组成语句的规则。在文法类中，每条规则都有对应的同名方法。

```java
/** 文法G对应的类 */
public class G {
    /** 解析规则1的方法 */
    public void rule1(){}
    
    /** 解析规则2的方法 */
    public void rule2(){}
    
    ...
    
    /** 解析规则n的方法 */
    public void rulen(){}
}
```

### 规则的转换

#### 等价子规则转换

`(alt1 | alt2 | .. | altn)`

```
if (lookahead == alt1) {}
else if (lookahead == alt2) {}
else if (lookahead == altn) {}
else { raise error }
```

#### 可选子规则`(T)?`的转换

```
if (lookahead == T) { match(T); }
```

#### 可选子规则`(T)+`的转换

```
do {
    match(T);
} while (lookahead == T);
```

#### 可选子规则(T)*的转换

```
while (lookahead == T) {
    match(T);
}
```

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
