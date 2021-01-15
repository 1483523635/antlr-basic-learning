package com.xiaoqu.demo.labeled.expr;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

public class LabeledExprMain {

    public static void main(String[] args) {
        ANTLRInputStream inputStream = new ANTLRInputStream(
             "a=5\n"
            + "b=6\n"
            + "a+b*2\n");
        LabeledExprLexer lexer = new LabeledExprLexer(inputStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        LabeledExprParser parser = new LabeledExprParser(tokenStream);
        EvalVisitor visitor = new EvalVisitor();
        LabeledExprParser.ProgContext tree = parser.prog();
        Integer result = visitor.visit(tree);
        System.out.println(result +"    calc result");
    }

}
