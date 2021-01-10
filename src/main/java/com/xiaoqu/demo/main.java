package com.xiaoqu.demo;

import com.xiaoqu.demo.arrayInit.ArrayInitLexer;
import com.xiaoqu.demo.arrayInit.ArrayInitParser;
import java.io.IOException;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class main {

    public static void main(String[] args) throws IOException {
        ANTLRInputStream input = new ANTLRInputStream("{1,2,3}");

        ArrayInitLexer lexer = new ArrayInitLexer(input);

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        ArrayInitParser parser = new ArrayInitParser(tokens);

        ParseTree tree = parser.value();

        System.out.println(tree.toStringTree(parser));
    }
}
