package parser;

import builtins.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainConsole {

    public static Map<String, String> variables = new HashMap<>();

    public static void main(String[] args) {
        Parser p = new Parser();
        String commandLine;
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.print("prelude>");
            try {
                commandLine = console.readLine();
                ParseResult result = p.parseInput(commandLine);
                List<Command> commands = result.getCommands();
                List<String> assignments = result.getAssignments();
                String output = "";
                for (Command c : commands) {
                    switch (c.getName()) {
                        case "echo" -> {
                            output = Echo.execute(c, output);
                        }
                        case "wc" -> {
                            output = Wc.execute(c, output);
                        }
                        case "pwd" -> {
                            output = Pwd.execute(c, output);
                        }

                        case "cat" -> {
                            output = Cat.execute(c, output);
                        }
                        default -> System.out.println("No such command");
                    }
                }

                for (String assignment: assignments) {
                    output = EnvMover.execute(assignment, output);
                }

                System.out.print(output);

            } catch (IOException | UnexpectedTokenException | NoSuchFileException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
