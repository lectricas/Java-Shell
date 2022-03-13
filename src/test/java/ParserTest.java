import org.junit.jupiter.api.Test;
import parser.Command;
import parser.ParseResult;
import parser.Parser;
import parser.UnexpectedTokenException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParserTest {

    Parser p = new Parser();

    List<Command> expected1 = Arrays.asList(
            new Command("echo", Arrays.asList("123")),
            new Command("wc", new ArrayList<>())
    );

    List<Command> expected2 = Arrays.asList(
            new Command("echo", Arrays.asList("123"))
    );

    List<Command> expected3 = Arrays.asList(
            new Command("echo", Arrays.asList("-n", "123"))
    );

    @Test
    void testParser() throws UnexpectedTokenException {
        List<Command> actual1 = p.parseInput("echo 123 | wc").getCommands();
        assertEquals(expected1, actual1);

        List<Command> actual2 = p.parseInput("echo 123").getCommands();
        assertEquals(expected2, actual2);

        List<Command> actual3 = p.parseInput("echo -n 123").getCommands();
        assertEquals(expected3, actual3);

        Throwable exception = assertThrows(
                UnexpectedTokenException.class,
                () -> p.parseInput("|dfs")
        );
        assertEquals("Unexpected token near |", exception.getMessage());
    }


    @Test
    void testParser1() throws UnexpectedTokenException {
        ParseResult actual1 = p.parseInput("a=4 echo hello");
        System.out.println(actual1);

        ParseResult actual2 = p.parseInput("a=4");
        System.out.println(actual2);

        ParseResult actual3 = p.parseInput("echo hello a=4");
        System.out.println(actual3);

        ParseResult actual4 = p.parseInput("a=4 b=8");
        System.out.println(actual4);

        ParseResult actual5 = p.parseInput("a=4 | b=8");
        System.out.println(actual5);

        ParseResult actual6 = p.parseInput("\"$(echo wc)\" testfile");
        System.out.println(actual6);

        ParseResult actual7 = p.parseInput("echo \"$(echo testfile)\"");
        System.out.println(actual7);

        ParseResult actual8 = p.parseInput("\"echo\" | wc");
        System.out.println(actual8);

        ParseResult actual9 = p.parseInput("echo \"$a\" | \"wc\"");
        System.out.println(actual9);
    }
}
