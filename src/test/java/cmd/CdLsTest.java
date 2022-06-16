package cmd;

import org.junit.jupiter.api.Test;
import parser.Bash;

import java.io.File;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CdLsTest {
    @Test
    public void testCdThenLs() {
        String expected = "test\nmain\n";

        Bash.runExternal("cd src");
        String actual = Bash.runExternal("ls");

        assertEquals(expected, actual);
    }

    @Test
    public void testDoubleCdAndLs() {
        String expected = "java\n";

        Bash.runExternal("cd src/test");
        String actual = Bash.runExternal("ls");
        assertEquals(expected, actual);

        Bash.runExternal("cd ..");

        String newExpected = "test\nmain\n";
        String newActual = Bash.runExternal("ls");
        assertEquals(newExpected, newActual);

    }

    @Test
    public void testThrowErrorCd() {
        // restore correct path since pwd was updated
        Bash.runExternal("cd ..");
        System.out.println(Bash.runExternal("pwd"));
        String expected =
                "java.lang.IllegalArgumentException: " +
                "File was given for cd command. " +
                "Expected folder path\n";

        String actual = Bash.runExternal("cd testfile");
        assertEquals(expected, actual);

        Bash.runExternal("cd nonExistingFolder");

        String newExpected =
                "java.lang.IllegalArgumentException: " +
                "Invalid path for cd command\n";

        String newActual = Bash.runExternal("cd nonExistingFolder");;
        assertEquals(newExpected, newActual);

    }
}