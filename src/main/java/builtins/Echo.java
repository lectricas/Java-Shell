package builtins;

import org.jetbrains.annotations.Nullable;
import parser.Command;

public class Echo {
    public static String execute(Command command, @Nullable String stdin) {
        StringBuilder echoWhat = new StringBuilder();
        if (!command.getArguments().isEmpty() && command.getArguments().get(0).equals("-n")) {
            for (int i = 1; i < command.getArguments().size(); i++) {
                echoWhat.append(command.getArguments().get(i));
            }
        } else {
            for (String arg : command.getArguments()) {
                echoWhat.append(arg);
            }
            echoWhat.append("\n");
        }
        return echoWhat.toString();
    }
}
