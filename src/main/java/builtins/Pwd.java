package builtins;

import bntler.BashCommand;
import parser.Environment;

import java.nio.file.Paths;

public class Pwd {
    public static String execute(BashCommand command, String stdin) {
        return Environment.values.get("PWD") + "\n";
    }
}
