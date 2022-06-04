package parser;


import builtins.Cat;
import builtins.Echo;
import builtins.Pwd;
import builtins.Wc;

public class Interpreter implements Expr.Visitor<String> {

    private String result = "";

    public static Environment environment = new Environment();

    String interpret(Expr statements) {
        try {
            Object value = evaluate(statements);
            return stringify(value);

        } catch (RuntimeError error) {
            Bash.runtimeError(error);
        }
        return "";
    }

    private String evaluate(Expr statements) {
        return statements.accept(this);
    }


    @Override
    public String visitPipeExpr(Expr.Pipe expr) {
        result = evaluate(expr.left);
        return evaluate(expr.right);
    }

    @Override
    public String visitApplicationExpr(Expr.Application expr) {
        evaluate(expr.left);
        evaluate(expr.right);
        return null;
    }

    @Override
    public String visitCommandExpr(Expr.Command expr) {
        switch (expr.operator.type) {
            case WC -> {
                return Wc.execute1(expr, result);
            }
            case ECHO -> {
                return Echo.execute1(expr, result);
            }
            case PWD -> {
                return Pwd.execute1(expr, result);
            }
            case CAT -> {
                return Cat.execute1(expr, result);
            }
//            case SINGLE_S ->  {
//
//            }
//            case DOUBLE_S ->  {
//
//            }
            default -> {

            }
        }
        return null;
    }

    private String stringify(Object object) {
        if (object == null) return "nil";

        // Hack. Work around Java adding ".0" to integer-valued doubles.
        if (object instanceof Double) {
            String text = object.toString();
            if (text.endsWith(".0")) {
                text = text.substring(0, text.length() - 2);
            }
            return text;
        }

        return object.toString();
    }

    @Override
    public String visitAssignmentExpr(Expr.Assignment expr) {
        environment.define(expr.left.rawText, expr.right.rawText);
        return "";
    }

    @Override
    public String visitLiteralExpr(Expr.Literal expr) {
        // TODO: 20.04.2022 add variable
        if (expr.value.startsWith("$")) {
            return environment.get(expr.value.substring(1));
        } else {
            return expr.value;
        }
    }

    @Override
    public String visitUnaryExpr(Expr.Unary expr) {
        return null;
    }
}
