package parser;

import java.util.List;

public class ParseResult {

    private List<String> assignments;
    private List<String> doubleQuotes;
    private List<Command> commands;

    public ParseResult(List<String> assignments, List<Command> commands, List<String> doubleQuotes) {
        this.assignments = assignments;
        this.commands = commands;
        this.doubleQuotes = doubleQuotes;
    }

    public List<String> getAssignments() {
        return assignments;
    }

    public List<String> getDoubleQuotes() {
        return assignments;
    }

    public List<Command> getCommands() {
        return commands;
    }


    @Override
    public String toString() {
        return "ParseResult{" +
                "assignments=" + assignments +
                ", doubleQuotes=" + doubleQuotes +
                ", commands=" + commands +
                '}';
    }
}
