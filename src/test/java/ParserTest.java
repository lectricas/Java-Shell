import org.junit.jupiter.api.Test;
import parser.Command;
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
        List<Command> actual1 = p.parseInput("echo 123 | wc");
        assertEquals(expected1, actual1);

        List<Command> actual2 = p.parseInput("echo 123");
        assertEquals(expected2, actual2);

        List<Command> actual3 = p.parseInput("echo -n 123");
        assertEquals(expected3, actual3);

        Throwable exception = assertThrows(
                UnexpectedTokenException.class,
                () -> p.parseInput("|dfs")
        );
        assertEquals("Unexpected token near |", exception.getMessage());
    }
}
