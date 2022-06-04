package bntler;

import antlr.BashBaseVisitor;
import antlr.BashParser;
import parser.Environment;

import java.util.Map;

public class WordOrStringVisitor extends BashBaseVisitor<String> {

    @Override
    public String visitAssign(BashParser.AssignContext ctx) {
        visit(ctx.assignment());
        return "";
    }

    @Override
    public String visitPartWord(BashParser.PartWordContext ctx) {
        return ctx.WORD().toString();
    }

    @Override
    public String visitPartVariable(BashParser.PartVariableContext ctx) {
        return Environment.values.get(ctx.WORD().toString());
    }

    @Override
    public String visitVariableAssignment(BashParser.VariableAssignmentContext ctx) {
        String newVar = Environment.values.get(ctx.WORD(1).toString());
        Environment.values.put(ctx.WORD(0).toString(), newVar);
        return "";
    }

    @Override
    public String visitWordAssignment(BashParser.WordAssignmentContext ctx) {
        // TODO: 02.06.2022 figure out how to make this smoother
        Environment.values.put(ctx.WORD(0).toString(), ctx.WORD(1).toString());
        return "";
    }

    @Override
    public String visitDqstr(BashParser.DqstrContext ctx) {
        String dqstr = ctx.DQSTR().toString();
        String noQuotes = dqstr.substring(1, dqstr.length() - 1);

        for (Map.Entry<String, String> entry : Environment.values.entrySet()) {
            if (noQuotes.contains("$"+entry.getKey())) {
                noQuotes = noQuotes.replace("$"+entry.getKey(), entry.getValue());
            }
        }
        return noQuotes;
    }

    @Override
    public String visitSqstr(BashParser.SqstrContext ctx) {
        String sqstr = ctx.SQSTR().toString();
        return sqstr.substring(1, sqstr.length() - 1);
    }
}
