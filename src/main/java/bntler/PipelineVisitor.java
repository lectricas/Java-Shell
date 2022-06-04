package bntler;

import antlr.BashBaseVisitor;
import antlr.BashLexer;
import antlr.BashParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.util.Objects;

public class PipelineVisitor extends BashBaseVisitor<BashNode> {

    WordOrStringVisitor wordOrStringVisitor = new WordOrStringVisitor();

    @Override
    public BashNode visitPipe(BashParser.PipeContext ctx) {
        return visit(ctx.pipeline());
    }

    @Override
    public BashNode visitMultipleCommands(BashParser.MultipleCommandsContext ctx) {
        var left = visit(ctx.left);
        var right = visit(ctx.right);
        return new BashPipeline(left, right);
    }

    @Override
    public BashNode visitSingleCommand(BashParser.SingleCommandContext ctx) {
        return visit(ctx.command());
    }

    @Override
    public BashNode visitCommand(BashParser.CommandContext ctx) {
        var command = ctx.children.stream()
                .map(it -> wordOrStringVisitor.visit(it))
                .filter(Objects::nonNull)
                .toList();
        return new BashCommand(command);
    }

    @Override
    public BashNode visitAssign(BashParser.AssignContext ctx) {
        return new BashAssignment(wordOrStringVisitor.visit(ctx.assignment()));
    }
}
