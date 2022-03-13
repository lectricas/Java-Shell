package builtins;

import parser.Command;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Cat {
    public static String execute(Command command, String stdin) throws NoSuchFileException {
        List<String> args = command.getArguments();
        int i = 0;
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
            try {
                Path path = Paths.get(args.get(i));
                concatenated.append(Files.readString(path, StandardCharsets.UTF_8));
            } catch (IOException e) {
                throw new NoSuchFileException("No such file " +args.get(i));
            }
            i++;
        }
        return concatenated.toString();
    }
}
