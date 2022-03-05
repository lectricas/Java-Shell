package parser;

import builtins.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        Parser p = new Parser();
        String commandLine;
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.print("prelude>");
            try {
                commandLine = console.readLine();
                List<Command> commands = p.parseInput(commandLine);
                String output = null;
                for (Command c : commands) {
                    switch (c.name) {
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
                System.out.println(output);

            } catch (IOException | UnexpectedTokenException | NoSuchFileException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
