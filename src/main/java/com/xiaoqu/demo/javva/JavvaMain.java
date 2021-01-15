package com.xiaoqu.demo.javva;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class JavvaMain {

    public static void main(String[] args) {
        ANTLRInputStream inputStream = new ANTLRInputStream("class demo {\n"
            + "    void f(int x, String y) { }\n"
            + "    int[ ] g(/*no args*/) { return null; }\n"
            + "    List<Map<String, Integer>>[] h() { return null; }\n"
            + "}");
        JavvaLexer lexer = new JavvaLexer(inputStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        JavvaParser parser = new JavvaParser(tokenStream);

        ParseTree tree = parser.build();

        ParseTreeWalker walker = new ParseTreeWalker();
        JavvaInterfaceListener listener = new JavvaInterfaceListener(parser);
        walker.walk(listener, tree);

    }
}
