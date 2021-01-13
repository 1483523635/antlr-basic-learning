grammar Javva;

build: import_define* class_define;

import_define: 'import' ('static')? qualified_name ('.*')? ';';

qualified_name:  Identifier ('.' Identifier)*;

class_define: 'class' Identifier class_body;

class_body: '{' method_declaration* '}';

method_declaration: ';' | type_define Identifier method_declaration_rest | 'void' Identifier method_declaration_rest;
method_declaration_rest: '(' comment* args_define? ')' '{' method_body? '}';
args_define: args (',' args)*;
args: type_define Identifier;
method_body: ';' | return_statement ;
return_statement: 'return' .*? ';';
comment: '/*' .*? '*/';
type_define: type ('[' ']')*;
type: INT | STRING | INTEGER | LIST ('<' type '>')? | MAP ('<' type ',' type '>');

INT: 'int';
LIST: 'List';
MAP: 'Map';
STRING: 'String';
INTEGER: 'Integer';
Identifier: ID (ID)*;
ID: [a-zA-Z]+;
WS: [ \r\n] -> skip;
