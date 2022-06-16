package builtins;

import bntler.BashCommand;
import parser.Environment;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Cd {
    public static String execute(BashCommand command, String stdin)  {
        if (command.parts().size() != 2) {
            throw new IllegalArgumentException("Cd command expects path");
        }


        var currPath = Path.of(Environment.values.get("PWD"), command.parts().get(1));

        if (!Files.exists(currPath)) {
            throw new IllegalArgumentException("Invalid path for cd command");
        }

        if (!Files.isDirectory(currPath)) {
            throw new IllegalArgumentException("File was given for cd command. Expected folder path");
        }

        Environment.values.put("PWD", currPath.toAbsolutePath().normalize().toString());
        return "";
    }

}
