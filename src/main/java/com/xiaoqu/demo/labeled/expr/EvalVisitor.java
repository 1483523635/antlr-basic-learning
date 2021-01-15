package com.xiaoqu.demo.labeled.expr;

import java.util.HashMap;
import java.util.Map;
import org.antlr.v4.runtime.CommonTokenStream;

public class EvalVisitor extends LabeledExprBaseVisitor<Integer> {

    private Map<String, Integer> memory = new HashMap<>();

    @Override
    public Integer visitAssign(LabeledExprParser.AssignContext ctx) {
        String id = ctx.ID().getText();
        int value = visit(ctx.expr());
        memory.put(id, value);
        return value;
    }

    @Override
    public Integer visitPrintExpr(LabeledExprParser.PrintExprContext ctx) {
        Integer value = visit(ctx.expr());
        System.out.println(value + "==============");
        return value;
    }

    @Override
    public Integer visitInt(LabeledExprParser.IntContext ctx) {
        return Integer.parseInt(ctx.INT().getText());
    }

    @Override
    public Integer visitId(LabeledExprParser.IdContext ctx) {
        String id = ctx.ID().getText();
        if (memory.containsKey(id)) {
            return memory.get(id);
        }
        return 0;
    }

    @Override
    public Integer visitMulDiv(LabeledExprParser.MulDivContext ctx) {
        Integer left = visit(ctx.expr(0));
        Integer right = visit(ctx.expr(1));
        if(ctx.op.getType() == LabeledExprLexer.DIV) {
            return left / right;
        }
        return left * right;
    }

    @Override
    public Integer visitAddSub(LabeledExprParser.AddSubContext ctx) {
        Integer left = visit(ctx.expr(0));
        Integer right = visit(ctx.expr(1));
        if (ctx.op.getType() == LabeledExprLexer.ADD) {
            return left + right;
        }
        return left - right;
    }

    @Override
    public Integer visitParens(LabeledExprParser.ParensContext ctx) {
        return visit(ctx.expr());
    }


}
