package builtins;

import bntler.BashCommand;
import org.jetbrains.annotations.Nullable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

//lazy javadoc
//-i - ignore case
//-w - complete word
//-A - after context

public class Grep {

    private static final int STATE_INITIAL = 0;
    private static final int STATE_DASH_A_WORDS_COMPLETED = 1;
    private static final int STATE_HAVE_MORE_WORDS_AFTER_DASH_A = 2;

    public static String execute(BashCommand command, @Nullable String stdin) {

        boolean ignoreCase = false;
        int linesAfterMatch = 0;
        boolean exactMatch = false;

        int i = 1;
        while (i < command.parts().size()) {
            String arg = command.parts().get(i);
            if (!arg.startsWith("-")) {
                break;
            }

            switch (arg) {
                case "-i" -> ignoreCase = true;
                case "-w" -> exactMatch = true;
                case "-A" -> {
                    if (i + 1 < command.parts().size()) {
                        String number = command.parts().get(i + 1);
                        try {
                            linesAfterMatch = Integer.parseInt(number);
                            i++;
                        } catch (NumberFormatException e) {
                            return "Invalid Argument\n";
                        }
                    } else {
                        return "Invalid Argument\n";
                    }
                }
                default -> {
                    return "Unsupported parameter\n";
                }
            }
            i++;
        }

        if (i == command.parts().size()) {
            return "usage: grep [-w] [-A num] [-i] <pattern> <filenames...>\n";
        }

        String lookingFor = command.parts().get(i);
        i++;

        try {
            StringBuilder grepWhat = new StringBuilder();

            if (i == command.parts().size()) {
                for (String s : stdin.split("\n")) {
                    if (getMatch(s, lookingFor, ignoreCase, exactMatch)) {
                        grepWhat.append(s).append("\n");
                    }
                }
            } else if (i == command.parts().size() - 1) {
                String filename = command.parts().get(i);
                searchFile(grepWhat, filename, lookingFor, linesAfterMatch, ignoreCase, exactMatch, false);
            } else {
                while (i < command.parts().size()) {
                    String filename = command.parts().get(i);
                    searchFile(grepWhat, filename, lookingFor, linesAfterMatch, ignoreCase, exactMatch, true);
                    i++;
                }
            }
            return grepWhat.toString();
        } catch (IOException e) {
            return e.getMessage();
        }
    }


    private static void searchFile(StringBuilder builder, String filename, String pattern, int linesAfterMatch, boolean ignoreCase, boolean exactMatch, boolean multiFile) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;
        int linesToPrint = 0;
        int stateForDoubleDash = STATE_INITIAL;
        while ((line = br.readLine()) != null) {
            boolean matched = getMatch(line, pattern, ignoreCase, exactMatch);
            if (matched) {
                if (stateForDoubleDash == STATE_HAVE_MORE_WORDS_AFTER_DASH_A) {
                    builder.append("--").append("\n");
                    stateForDoubleDash = STATE_INITIAL;
                }
                linesToPrint = linesAfterMatch;
                if (multiFile) {
                    builder.append(filename).append(":");
                }
                builder.append(line).append("\n");
            } else if (linesToPrint > 0) {
                builder.append(line).append("\n");
                linesToPrint--;
                if (linesToPrint == 0) {
                    stateForDoubleDash = STATE_DASH_A_WORDS_COMPLETED;
                }
            } else if (stateForDoubleDash == STATE_DASH_A_WORDS_COMPLETED) {
                stateForDoubleDash = STATE_HAVE_MORE_WORDS_AFTER_DASH_A;
            }
        }
    }

    private static boolean getMatch(String line, String pattern, boolean ignoreCase, boolean exactMatch) {
        if (ignoreCase) {
            line = line.toLowerCase();
            pattern = pattern.toLowerCase();
        }
        if (exactMatch) {
            return Arrays.asList(line.toLowerCase().split(" ")).contains(pattern);
        } else {
            return line.contains(pattern);
        }
    }
}
