package builtins;

import bntler.BashCommand;
import parser.Bash;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Cat {
    public static String execute(BashCommand command, String stdin) throws IOException {
        List<String> args = command.parts();
        int i = 1;
        while (i < args.size()) {
            if (!args.get(i).startsWith("-")) {
                break;
            }
            i++;
        }

        if (i == args.size()) {
            return stdin;
        }

        StringBuilder concatenated = new StringBuilder();
        while (i < args.size()) {
            Path path = Paths.get(args.get(i));
            concatenated.append(Files.readString(path, StandardCharsets.UTF_8));
            i++;
        }
        return concatenated.toString();
    }
}
