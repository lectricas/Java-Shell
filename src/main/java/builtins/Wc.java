package builtins;

import parser.Bash;
import parser.Expr;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;

public class Wc {
    public static String execute1(Expr.Command command, String stdin) {
        if (!command.arguments.isEmpty()) {
            try {
                Path path = Paths.get(command.arguments.get(0).literal);
                String content = Files.readString(path, StandardCharsets.US_ASCII);
                return wcInner(content);
            } catch (IOException e) {
                Bash.error("no such file");
                return "";
            }
        } else if (stdin != null) {
            return wcInner(stdin);
        } else {
            throw new IllegalStateException("Not Implemented");
        }
    }

    private static String wcInner(String input) {

        final Pattern nonWordPattern = Pattern.compile("\\W");
        long charCount = input.lines().flatMapToInt(String::chars).count();
        long lineCount = input.lines().count();
        long wordCount = input.lines()
                .flatMap(nonWordPattern::splitAsStream)
                .filter(str -> !str.isEmpty()).count();
        return lineCount + " " + wordCount + " " + charCount + "\n";
    }
}
