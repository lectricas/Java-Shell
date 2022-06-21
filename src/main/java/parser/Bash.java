package parser;

import antlr.BashLexer;
import antlr.BashParser;
import bntler.PipelineVisitor;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Bash {
    private static final Interpreter interpreter = new Interpreter();

    public static void main(String[] args) throws IOException {
        if (args.length > 1) {
            System.out.println("Usage: Bash [script]");
        } else {
            runPrompt();
        }
    }

    private static void runPrompt() throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);

        for (;;) {
            System.out.print("> ");
            run(reader.readLine());
        }
    }

    private static void run(String source) {
        String answer = runExternal(source);
        System.out.print(answer);
    }

    public static String runExternal(String source) {

        if (source.isEmpty()) {
            return "\n";
        }

        var input = CharStreams.fromString(source);
        var lexer = new BashLexer(input);
        var tokens = new CommonTokenStream(lexer);
        var parser = new BashParser(tokens);
        var rootNode = parser.start();
        var rootNodeGood = new PipelineVisitor().visit(rootNode);
        String result;
        try {
            return interpreter.interpret(rootNodeGood);
        } catch (Exception e) {
//            e.printStackTrace(); for debug
            return e.getMessage() + "\n";
        }
    }
}
