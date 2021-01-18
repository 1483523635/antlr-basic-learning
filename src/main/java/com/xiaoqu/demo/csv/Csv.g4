grammar Csv;
file: (row NL)*;
row: field (';' field)*;
field: INT;
NL: '\r'? '\n';
INT: [0-9]+;

