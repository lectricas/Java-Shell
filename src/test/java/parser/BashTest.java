package parser;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BashTest {
    @Test
    public void testSimpleEcho() {
        String expected = "hello\n";
        String actual = Bash.runExternal("echo hello");
        assertEquals(expected, actual);

        String expected1 = "hello";
        String actual1 = Bash.runExternal("echo -n hello");
        assertEquals(expected1, actual1);
    }

    @Test
    public void testSimpleWc() {
        String expected = "1 1 10 wctest\n";
        String actual = Bash.runExternal("wc wctest");
        assertEquals(expected, actual);
    }

    @Test
    public void testSimplePwd() {
        String expected = Path.of(new File("").getAbsolutePath()) + "\n";
        String actual = Bash.runExternal("pwd");
        assertEquals(expected, actual);
    }

    @Test
    public void testSimpleCat() {
        String expected = "hello world";
        String actual = Bash.runExternal("cat cattest");
        assertEquals(expected, actual);
    }

    @Test
    public void randomCommand() {
        String expected = "java.io.IOException: Cannot run program \"rrandom\": error=2, No such file or directory\n";
        String actual = Bash.runExternal("rrandom");
        assertEquals(expected, actual);
    }

    @Test
    public void testSimpleVariable() {
        String expected = "java.io.IOException: Cannot run program \"rrandom\": error=2, No such file or directory\n";
        Bash.runExternal("a=rrandom");
        String actual = Bash.runExternal("$a");
        assertEquals(expected, actual);
    }

    @Test
    public void testVariableWithCommand() {
        String expected = Path.of(new File("").getAbsolutePath()) + "\n";
        Bash.runExternal("a=pwd");
        String actual = Bash.runExternal("$a");
        assertEquals(expected, actual);
    }

    @Test
    public void testSimpleDString() {
        String expected = Path.of(new File("").getAbsolutePath()) + "\n";
        String actual = Bash.runExternal("\"pwd\"");
        assertEquals(expected, actual);
    }

    @Test
    public void testSimpleVariableWithDString() {
        String expected = "java.io.IOException: Cannot run program \"rrandom\": error=2, No such file or directory\n";
        Bash.runExternal("a=rrandom");
        String actual = Bash.runExternal("\"$a\"");
        assertEquals(expected, actual);
    }

    @Test
    public void testSimpleVariableWithSString() {
        String expected = "java.io.IOException: Cannot run program \"$a\": error=2, No such file or directory\n";
        Bash.runExternal("a=rrandom");
        String actual = Bash.runExternal("'$a'");
        assertEquals(expected, actual);
    }

    @Test
    public void testSomePipe() {
        String expected = "1 1 5\n";
        String actual = Bash.runExternal("echo hello | wc");
        assertEquals(expected, actual);
    }
}