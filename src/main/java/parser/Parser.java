package parser;

import java.util.ArrayList;
import java.util.List;

import static parser.TokenType.*;


public class Parser {
    private static class ParseError extends RuntimeException {
    }

    private final List<Token> tokens;
    private int current = 0;

    public Parser(List<Token> tokens) {
        this.tokens = tokens;
    }

    public Expr parse() {
        return pipe();
    }


    private Expr pipe() {
        Expr expr = application();

        while (match(PIPE)) {
            Expr right = application();
            expr = new Expr.Pipe(expr, right);
        }

        return expr;
    }

    private Expr application() {
        Expr left = assigmentOrCommand();
        if (left instanceof Expr.Command) {
            List<Token> arguments = new ArrayList<>();
            while (match(SPACE, EQUAL)) {
                advance();
                arguments.add(previous());
            }
            ((Expr.Command) left).arguments = arguments;
        } else {
            if (match(SPACE)) {
                Expr assigment = application();
                if (assigment instanceof Expr.Command) {
                    return assigment;
                } else {
                    return new Expr.Application(left, assigment);
                }
            }
        }
        return left;
    }

    private Expr assigmentOrCommand() {
        if (match(WC, ECHO, CAT, PWD)) {
            Token commandName = previous();
            return new Expr.Command(commandName, null);
        }
        return equal();
    }

    private Expr equal() {
        // TODO: 20.04.2022 change this
        if (tokens.get(current).type == WORD &&
                tokens.get(current + 1).type == EQUAL &&
                tokens.get(current + 2).type == WORD
        ) {
            Token left = tokens.get(current);
            Token right = tokens.get(current + 2);
            advance();
            advance();
            advance();
            return new Expr.Assignment(left, right);
        } else {
            return primary();
        }
    }

    private Expr primary() {
        if (match(WORD)) {
            return new Expr.Literal(previous().rawText);
        }

        throw error(peek(), "Word Expect expression.");
    }

    private boolean match(TokenType... types) {
        for (TokenType type : types) {
            if (check(type)) {
                advance();
                return true;
            }
        }

        return false;
    }

    private boolean check(TokenType tokenType) {
        if (isAtEnd()) return false;
        return peek().type == tokenType;
    }

    private Token advance() {
        if (!isAtEnd()) current++;
        return previous();
    }

    private boolean isAtEnd() {
        return peek().type == EOF;
    }

    private Token peek() {
        return tokens.get(current);
    }

    private Token previous() {
        return tokens.get(current - 1);
    }

    private ParseError error(Token token, String message) {
        Bash.error(token, message);
        return new ParseError();
    }
}