package com.xiaoqu.demo.csv;

import java.io.IOException;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

public class csvDemoMain {

    public static void main(String[] args) throws IOException {
        CharStream fileStream = CharStreams.fromFileName("/Users/lqqu/learning/antlr-basic-learning/src/main/java/com/xiaoqu/demo/csv/test.int.csv");
        CsvLexer lexer = new CsvLexer(fileStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        CsvParser parser = new CsvParser(tokenStream);

        ParseTree tree = parser.file();
        System.out.println(tree.toStringTree(parser));



//        ParseTreeWalker walker = new ParseTreeWalker();
//        CsvMyLisenter lisenter = new CsvMyLisenter();
//        walker.walk(lisenter, tree);


    }
}
