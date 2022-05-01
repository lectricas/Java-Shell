package parser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScannerTest {
    @Test
    void testMultipleCommandsNoPipe() {
        var pair = TestData.multiple();
        Scanner s = new Scanner(pair.fst());
        assertEquals(pair.snd(), s.scanTokens());
    }

    @Test
    void testMultipleCommandsPipe() {
        var pair = TestData.pipe();
        Scanner s = new Scanner(pair.fst());
        assertEquals(pair.snd(), s.scanTokens());
    }

    @Test
    void testDollar() {
        var pair = TestData.dollar();
        Scanner s = new Scanner(pair.fst());
        assertEquals(pair.snd(), s.scanTokens());
    }

    @Test
    void testWord() {
        var pair = TestData.word();
        Scanner s = new Scanner(pair.fst());
        assertEquals(pair.snd(), s.scanTokens());
    }

    @Test
    void testSingleInsideDoubleQuotes() {
        var pair = TestData.singleQuotes();
        Scanner s5 = new Scanner(pair.fst());
        assertEquals(pair.snd(), s5.scanTokens());
    }

    @Test
    void testDoubleQuotes() {
        var pair = TestData.singleQuotes();
        Scanner s6 = new Scanner(pair.fst());
        assertEquals(pair.snd(), s6.scanTokens());
    }
}