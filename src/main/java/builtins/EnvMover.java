package builtins;

import org.jetbrains.annotations.Nullable;
import parser.MainConsole;

public class EnvMover {
    public static String execute(String assignment, @Nullable String stdin) {
        int i = 0;
        while (i < assignment.length()) {
            if (assignment.charAt(i) == '=') {
                break;
            }
            i++;
        }
        String key = assignment.substring(0, i);
        String value = assignment.substring(i + 1);
        MainConsole.variables.put(key, value);
        return MainConsole.variables.toString();
    }
}
