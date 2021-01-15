package com.xiaoqu.demo.staff;

import java.io.IOException;
import org.antlr.v4.runtime.*;

public class Staff {

    public static void main(String[] args) throws IOException {
        CharStream stream = CharStreams.fromFileName("/Users/lqqu/learning/antlr-basic-learning/src/main/java/com/xiaoqu/demo/staff/t.rows");
        RowsLexer lexer = new RowsLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        int col = Integer.parseInt("1");
        RowsParser parser = new RowsParser(tokens, col); // pass column number!
        parser.setBuildParseTree(false); // don't waste time bulding a tree
        parser.file(); // parse
    }
}
