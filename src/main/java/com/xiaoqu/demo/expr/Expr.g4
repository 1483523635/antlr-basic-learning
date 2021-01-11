grammar Expr;
prog: stat+;
stat:  expr NEWLINE |ID '=' expr NEWLINE | expr | NEWLINE;
expr:  expr ( '*'|'/') expr | expr ('+'|'-') expr | '(' expr ')' | ID | INT ;
ID: [a-zA-Z]+;
NEWLINE: [\r]?[\n]*;
INT: [0-9]+;
WS: [ \t] -> skip;
