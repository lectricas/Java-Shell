package builtins;

import bntler.BashCommand;
import org.jetbrains.annotations.Nullable;

public class Echo {
    public static String execute(BashCommand command, @Nullable String stdin) {
        StringBuilder echoWhat = new StringBuilder();

        int i = 1;
        boolean flag = true;
        if (!command.parts().isEmpty() && command.parts().get(i).equals("-n")) {
            i++;
            flag = false;
        }

        for (; i < command.parts().size(); i++) {
            echoWhat.append(command.parts().get(i));
            if (i != command.parts().size() - 1) {
                echoWhat.append(" ");
            }
        }

        if (flag) {
            echoWhat.append("\n");
        }
        return echoWhat.toString();
    }
}
