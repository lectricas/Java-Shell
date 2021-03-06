package builtins;

import parser.Bash;
import parser.Expr;
import parser.Token;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Cat {
    public static String execute1(Expr.Command command, String stdin)  {
        List<Token> args = command.arguments;
        int i = 0;
        while (i < args.size()) {
            if (!args.get(i).literal.startsWith("-")) {
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
                Path path = Paths.get(args.get(i).literal);
                concatenated.append(Files.readString(path, StandardCharsets.UTF_8));
            } catch (IOException e) {
                Bash.error("No such file " +args.get(i));
            }
            i++;
        }
        return concatenated.toString();
    }
}
