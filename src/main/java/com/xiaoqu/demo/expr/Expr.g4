grammar Expr;
import Common;
prog: stat+;
stat:  expr NEWLINE |ID '=' expr NEWLINE | expr | NEWLINE;
expr:  expr ( '*'|'/') expr | expr ('+'|'-') expr | '(' expr ')' | ID | INT ;