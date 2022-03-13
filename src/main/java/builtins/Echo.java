package builtins;

import org.jetbrains.annotations.Nullable;
import parser.Command;
import parser.MainConsole;

public class Echo {
    public static String execute(Command command, @Nullable String stdin) {
        StringBuilder echoWhat = new StringBuilder();
        if (!command.getArguments().isEmpty() && command.getArguments().get(0).equals("-n")) {
            for (int i = 1; i < command.getArguments().size(); i++) {
                echoWhat.append(command.getArguments().get(i));
            }
        } else {
            for (String arg : command.getArguments()) {
                if (arg.startsWith("$")) {
                    String key = arg.substring(1);
                    if (MainConsole.variables.containsKey(key)) {
                        echoWhat.append(MainConsole.variables.get(key));
                    }

                } else {
                    echoWhat.append(arg);
                }
            }
            echoWhat.append("\n");
        }
        return echoWhat.toString();
    }
}
