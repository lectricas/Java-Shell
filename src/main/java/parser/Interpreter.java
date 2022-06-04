package parser;

import bntler.BashAssignment;
import bntler.BashCommand;
import bntler.BashNode;
import bntler.BashPipeline;
import builtins.Cat;
import builtins.Echo;
import builtins.Pwd;
import builtins.Wc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Interpreter {

    private String result = "";

    String interpret(BashNode node) throws Exception {
        if (node != null) {
            if (node instanceof BashPipeline) {
                result = interpret(((BashPipeline) node).left());
                result = interpret(((BashPipeline) node).right());
            } else if (node instanceof BashCommand) {
                return visitCommand((BashCommand) node);
            } else if (node instanceof BashAssignment) {
                return ((BashAssignment) node).result();
            } else {
                throw new IllegalStateException("Not implemented");
            }
        }
        return result;
    }

    public String visitCommand(BashCommand command) throws Exception {
        switch (command.parts().get(0)) {
            case "wc" -> {
                return Wc.execute(command, result);
            }
            case "echo" -> {
                return Echo.execute(command, result);
            }
            case "pwd" -> {
                return Pwd.execute(command, result);
            }
            case "cat" -> {
                return Cat.execute(command, result);
            }

            default -> {
                String strCommand = String.join(" ", command.parts());
                return executeCommand(strCommand);
            }
        }
    }

    private String executeCommand(String command) throws Exception {
        Process process = Runtime.getRuntime().exec(command);
        BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder b = new StringBuilder();

        while (true) {
            String line = in.readLine();
            if (line == null) {
                break;
            }
            b.append(line);
            b.append("\n");
        }
        return b.toString();
    }
}
