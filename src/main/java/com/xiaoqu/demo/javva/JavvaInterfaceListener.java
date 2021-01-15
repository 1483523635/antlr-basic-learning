package com.xiaoqu.demo.javva;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.TokenStream;

public class JavvaInterfaceListener extends JavvaBaseListener {

    private JavvaParser parser;

    public JavvaInterfaceListener(JavvaParser parser) {

        this.parser = parser;
    }

    @Override
    public void enterClass_define(JavvaParser.Class_defineContext ctx) {
        System.out.println("public interface I" + ctx.Identifier().getText() + " {");
    }

    @Override
    public void exitClass_define(JavvaParser.Class_defineContext ctx) {
        System.out.println(" }");
    }

    @Override
    public void enterMethod_declaration(JavvaParser.Method_declarationContext ctx) {
        String type = Optional.ofNullable(ctx.type_define()).map(r -> r.getText()).orElse("void");
//        System.out.print("public " + type + " " + ctx.Identifier());
        TokenStream tokenStream = parser.getTokenStream();
        String args = tokenStream.getText(ctx.method_declaration_rest());
        System.out.println("\t"+type+" "+ctx.Identifier()+args+";");
    }


    @Override
    public void exitMethod_declaration(JavvaParser.Method_declarationContext ctx) {
        System.out.println(";");
    }

}
