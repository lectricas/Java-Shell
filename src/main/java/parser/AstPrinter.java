package parser;

public class AstPrinter implements Expr.Visitor<String> {

    public String print(Expr expr) {
        return expr.accept(this);
    }

    @Override
    public String visitPipeExpr(Expr.Pipe expr) {
        return "PIPE (" + expr.left.accept(this) + ", " + expr.right.accept(this) + ")";
    }

    @Override
    public String visitApplicationExpr(Expr.Application expr) {
        return "APPLY" + expr.left.accept(this) + " " + expr.right.accept(this);
    }

    @Override
    public String visitLiteralExpr(Expr.Literal expr) {
        return expr.value.toString();
    }

    @Override
    public String visitAssignmentExpr(Expr.Assignment expr) {
        return "ASSIGN (" + expr.left + "=" + expr.right + ")";
    }

    @Override
    public String visitCommandExpr(Expr.Command expr) {
        return expr.operator.rawText + expr.arguments.stream().map(it -> it.rawText).toList().toString();
    }

    @Override
    public String visitUnaryExpr(Expr.Unary expr) {
        return "";
    }
}
