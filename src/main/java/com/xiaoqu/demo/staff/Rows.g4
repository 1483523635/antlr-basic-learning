grammar Rows;

@parser::members {
  int col;
  public RowsParser(TokenStream input, int col) {
    this(input);
    this.col = col;
  }
}

file: (row NL)+;
row locals [int i=0] :
    (STAFF {
      $i++;
        if($i == col) {
          System.out.println($STAFF.text);
        }
    })+;

TAB: '\t' -> skip;
NL: '\t'? '\n';
STAFF: ~[\t\r\n]+; //not match \t\r\n