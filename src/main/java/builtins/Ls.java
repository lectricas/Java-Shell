package builtins;

import bntler.BashCommand;
import parser.Environment;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Ls {
    public static String execute(BashCommand command, String stdin) throws IOException {
        var currDir = Paths.get(Environment.values.get("PWD"));
        var files = new StringJoiner("\n");

        try (DirectoryStream<Path> streamOfPaths = Files.newDirectoryStream(currDir)) {
            for (var p : streamOfPaths) {
                var currPath = p.getFileName().toString();
                if (!currPath.startsWith(".")) {
                    files.add(p.getFileName().toString());
                }

            }
        }


        return files.toString().concat("\n");
    }


}
