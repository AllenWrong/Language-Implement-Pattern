**Jack语言的完整语法**

```
keyword:        'class' | 'constructor' | 'function' | 'method' | 'field' | 'static' | 
                'var' | 'int' | 'char' | 'boolean' | 'void' | 'true' | 'false' | 'null' |
                'this' | 'let' | 'do' | 'if' | 'else' | 'while' | 'return'

symbol:         '{' | '}' | '(' | ')' | '[' |
                ']' | '.' | ',' | ';' | '+' |
                '-' | '*' | '/' | '&' | '|' |
                '<' | '>' | '=' | '~'

integerConstant:  0到32767的十进制整数

StringConstant:   

identitier:    

class:           'class' className '{' classVarDec* subroutineDec* '}'

classVarDec:     ('static' | 'field') type varName (',' varName)* ';'

type:            'int' | 'char' | 'boolean' | className

subroutineDec:   ('constructor' | 'function' | 'method') ('void' | type) 
                 subroutineName '(' parameterList ')' subroutineBody

parameterList:   ((type varName) (',' type varName)*)?

subroutineBody:  '{' varDec* statements '}'

varDec:          'var' type varName (',' varName)* ';'

className:       identitier

subroutineName:  identitier

varName:         identitier

statements:      statement*

statements:      letStatement | ifStatement | whileStatement |
                 doStatement | returnStatement
                 
letStatement:    'let' varName ('[' expression ']')? '=' expression ';'

ifStatement:     'if' '(' expression ')' '{' statements '}'
                 ('else' '{' statements '}')?

whileStatement:  'while' '(' expression ')' '{' statements '}'

doStatement:     'do' subroutineCall ';'

returnStatement: 'return' expression? ';'

expression:      term (op term)*

term:            integerConstant | StringConstant | keywordConstant | varName |
                 varName '[' expression ']' | subroutineCall |
                 '(' expression ')' | unaryOp term
                 
subroutineCall:  subroutineName '(' expressionList ')' | (className | varName) '.'
                 subroutineName '(' expressionList ')'
                 
expressionList:  (expression (',' expression)*)?

op:              '+' | '-' | '*' | '/' | '&' | '|' | '<' | '>' | '='

unaryOp:         '-' | '~'

keywordConstant: 'true' | 'false' | 'null' | 'this'
```

