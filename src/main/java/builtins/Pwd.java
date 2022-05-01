package builtins;

import parser.Expr;

import java.nio.file.Paths;

public class Pwd {
    public static String execute1(Expr.Command command, String stdin) {
        return Paths.get(".").toAbsolutePath().normalize().toString();
    }
}
