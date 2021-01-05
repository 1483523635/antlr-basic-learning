package com.xiaoqu.demo;

import java.io.IOException;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class main {

    public static void main(String[] args) throws IOException {
        ANTLRInputStream input = new ANTLRInputStream("a=11;");

        AssignLexer lexer = new AssignLexer(input);

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        AssignParser parser = new AssignParser(tokens);

        ParseTree tree = parser.assign();

        System.out.println(tree.toStringTree(parser));
    }
}
