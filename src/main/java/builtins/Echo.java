package builtins;

import org.jetbrains.annotations.Nullable;
import parser.*;

public class Echo {
    public static String execute1(Expr.Command command, @Nullable String stdin) {
        StringBuilder echoWhat = new StringBuilder();

        int i = 0;
        boolean flag = true;
        if (!command.arguments.isEmpty() && command.arguments.get(0).literal.equals("-n")) {
            i = 1;
            flag = false;
        }

        for (; i < command.arguments.size(); i++) {
            Token tok = command.arguments.get(i);
            if (tok.type == TokenType.SINGLE_S) {
                echoWhat.append(tok.literal);
            } else if (tok.type == TokenType.DOUBLE_S) {
                echoWhat.append(Bash.runExternal(tok.literal));
            } else {
                if (tok.literal.startsWith("$")) {
                    String key = tok.literal.substring(1);
                    echoWhat.append(Interpreter.environment.get(key));
                } else {
                    echoWhat.append(tok.literal);
                }
            }
            echoWhat.append(" ");
        }

        if (flag) {
            echoWhat.append("\n");
        }
        return echoWhat.toString();
    }
}
