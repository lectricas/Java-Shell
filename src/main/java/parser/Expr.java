package parser;

import java.util.List;

public abstract class Expr {

    interface Visitor<R> {
        R visitPipeExpr(Pipe expr);
        R visitApplicationExpr(Application expr);
        R visitLiteralExpr(Literal expr);
        R visitAssignmentExpr(Assignment expr);
        R visitCommandExpr(Command expr);
        R visitUnaryExpr(Unary expr);
    }

    static class Pipe extends Expr {
        Pipe(Expr left, Expr right) {
            this.left = left;
            this.right = right;
        }

        <R> R accept(Visitor<R> visitor) {
            return visitor.visitPipeExpr(this);
        }

        final Expr left;
        final Expr right;
    }

    static class Application extends Expr {
        Application(Expr left, Expr right) {
            this.left = left;
            this.right = right;
        }

        <R> R accept(Visitor<R> visitor) {
            return visitor.visitApplicationExpr(this);
        }

        final Expr left;
        final Expr right;

    }

    public static class Command extends Expr {
        Command(Token operator, List<Token> arguments) {
            this.operator = operator;
            this.arguments = arguments;
        }

        <R> R accept(Visitor<R> visitor) {
            return visitor.visitCommandExpr(this);
        }

        public final Token operator;
        public List<Token> arguments;

//        public List<String> getArguments() {
//            return right.stream().map(it -> it.lexeme).toList();
//        }

    }

    static class Assignment extends Expr {
        Assignment(Token left, Token right) {
            this.left = left;
            this.right = right;
        }

        <R> R accept(Visitor<R> visitor) {
            return visitor.visitAssignmentExpr(this);
        }

        final Token left;
        final Token right;
    }

    static class Unary extends Expr {
        Unary(Token operator, Expr right) {
            this.operator = operator;
            this.right = right;
        }

        <R> R accept(Visitor<R> visitor) {
            return visitor.visitUnaryExpr(this);
        }

        final Token operator;
        final Expr right;

    }

    static class Literal extends Expr {
        Literal(String value) {
            this.value = value;
        }

        <R> R accept(Visitor<R> visitor) {
            return visitor.visitLiteralExpr(this);
        }

        final String value;


    }

    abstract <R> R accept(Visitor<R> visitor);
}
