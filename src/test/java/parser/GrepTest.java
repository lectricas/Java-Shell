package parser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GrepTest {

    @Test
    public void testSimpleGrep() {
        String expected = "hello\nhello1\n";
        String actual = Bash.runExternal("grep hello greptest1");
        assertEquals(expected, actual);
    }

    @Test
    public void testWGrep() {
        String expected = "hello\n";
        String actual = Bash.runExternal("grep -w hello greptest1");
        assertEquals(expected, actual);
    }

    @Test
    public void testA2WGrep() {
        String expected = "hello\nhello1\n123\n";
        String actual = Bash.runExternal("grep -A 2 -w hello greptest1");
        assertEquals(expected, actual);

        String actual1 = Bash.runExternal("grep -w -A 2 hello greptest1");
        assertEquals(expected, actual1);
    }

    @Test
    public void testIGrep() {
        String expected = "hello\nhello\nHELLOWORLD\nHELLO\n";
        String actual = Bash.runExternal("grep -i hello greptest");
        assertEquals(expected, actual);
    }

    @Test
    public void testIA2Grep() {
        String expected = """
                hello
                hello
                fsdfsd
                sdfsdf
                --
                HELLOWORLD
                dsfsdf
                sdfdsf
                HELLO
                """;
        String actual = Bash.runExternal("grep -i -A 2 hello greptest");
        assertEquals(expected, actual);
    }

    @Test
    public void testIA2WGrep() {
        String expected = """
                hello
                hello
                fsdfsd
                sdfsdf
                --
                HELLO
                """;
        String actual = Bash.runExternal("grep -i -w -A 2 hello greptest");
        assertEquals(expected, actual);
    }

    @Test
    public void testPipe() {
        String expected = """
                hello
                hello
                """;
        String actual = Bash.runExternal("cat greptest | grep hello");
        assertEquals(expected, actual);
    }


    @Test
    public void multiFile() {
        String expected = """
                greptest:hello
                greptest:hello
                greptest1:hello
                greptest1:hello1
                """;
        String actual = Bash.runExternal("grep hello greptest greptest1");
        assertEquals(expected, actual);
    }
}
