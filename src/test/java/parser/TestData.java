package parser;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestData {
    public static Pair<String, List<Token>> singleQuotes() {
        List<Token> expected = new ArrayList<>();
        expected.add(new Token(TokenType.ECHO, "echo", "echo"));
        expected.add(new Token(TokenType.SPACE));
        expected.add(new Token(TokenType.SINGLE_S, "'hello$a'", "hello$a"));
        expected.add(new Token(TokenType.EOF));
        return new Pair<>("echo 'hello$a'", expected);
    }

    public static Pair<String, List<Token>> singleInsideDoubleQuotes() {
        List<Token> expected = new ArrayList<>();
        expected.add(new Token(TokenType.ECHO, "echo", "echo"));
        expected.add(new Token(TokenType.SPACE));
        Token tok1 = new Token(TokenType.DOUBLE_S, "\"'$a'\"", "'$a'");
        tok1.ifString = List.of(
                new Token(TokenType.SINGLE_S, "'$a'", "$a"),
                new Token(TokenType.EOF)
        );
        expected.add(tok1);
        expected.add(new Token(TokenType.EOF));
        return new Pair<>("echo \"'$a'\"", expected);
    }

    public static Pair<String, List<Token>> word() {
        List<Token> expected = List.of(
                new Token(TokenType.ECHO, "echo", "echo"),
                new Token(TokenType.SPACE),
                new Token(TokenType.WORD, "b", "b"),
                new Token(TokenType.EOF)
        );
        return new Pair<>("echo b", expected);
    }

    public static Pair<String, List<Token>> dollar() {
        List<Token> expected = List.of(
                new Token(TokenType.ECHO, "echo", "echo"),
                new Token(TokenType.SPACE),
                new Token(TokenType.WORD, "$a", "$a"),
                new Token(TokenType.EOF)
        );
        return new Pair<>("echo $a", expected);
    }

    public static Pair<String, List<Token>> pipe() {
        List<Token> expected = List.of(
                new Token(TokenType.PWD, "pwd", "pwd"),
                new Token(TokenType.SPACE),
                new Token(TokenType.WORD, "-l", "-l"),
                new Token(TokenType.SPACE),
                new Token(TokenType.WORD, "-a", "-a"),
                new Token(TokenType.PIPE),
                new Token(TokenType.WC, "wc", "wc"),
                new Token(TokenType.SPACE),
                new Token(TokenType.WORD, "123", "123"),
                new Token(TokenType.EOF)
        );
        return new Pair<>("pwd -l -a | wc 123", expected);
    }

    public static Pair<String, List<Token>> multiple() {

        List<Token> expected = List.of(
                new Token(TokenType.WC, "wc", "wc"),
                new Token(TokenType.SPACE),
                new Token(TokenType.WORD, "-l", "-l"),
                new Token(TokenType.SPACE),
                new Token(TokenType.WORD, "-a", "-a"),
                new Token(TokenType.SPACE),
                new Token(TokenType.WORD, "a", "a"),
                new Token(TokenType.EQUAL),
                new Token(TokenType.WORD, "4", "4"),
                new Token(TokenType.EOF)
        );

        return new Pair<>("wc -l -a a=4", expected);
    }
}
