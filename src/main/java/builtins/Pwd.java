package builtins;

import bntler.BashCommand;

import java.nio.file.Paths;

public class Pwd {
    public static String execute(BashCommand command, String stdin) {
        return Paths.get(".").toAbsolutePath().normalize().toString() + "\n";
    }
}
