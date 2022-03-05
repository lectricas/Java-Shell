package builtins;

import parser.Command;

import java.nio.file.Paths;

public class Pwd {
    public static String execute(Command command, String stdin) {
        return Paths.get(".").toAbsolutePath().normalize().toString();
    }
}
