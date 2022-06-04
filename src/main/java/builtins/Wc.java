package builtins;

import bntler.BashCommand;
import parser.Bash;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;

public class Wc {
    public static String execute(BashCommand command, String stdin) throws IOException {
        if (command.parts().size() > 1) {
            Path path = Paths.get(command.parts().get(1));
            String content = Files.readString(path, StandardCharsets.US_ASCII);
            return wcInner(content, path.getFileName().toString());
        } else if (stdin != null) {
            return wcInner(stdin, "");
        } else {
            throw new IllegalStateException("Not Implemented");
        }
    }

    private static String wcInner(String input, String path) {

        final Pattern nonWordPattern = Pattern.compile("\\W");
        long charCount = input.lines().flatMapToInt(String::chars).count();
        long lineCount = input.lines().count();
        long wordCount = input.lines()
                .flatMap(nonWordPattern::splitAsStream)
                .filter(str -> !str.isEmpty()).count();
        if (path.isEmpty()) {
            return lineCount + " " + wordCount + " " + charCount + "\n";
        } else {
            return lineCount + " " + wordCount + " " + charCount + " " + path + "\n";
        }
    }
}
