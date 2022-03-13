package parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private final Map<State, Map<Token, State>> states = new HashMap<>() {{
        put(State.START, new HashMap<>() {{
            put(Token.PIPE1, State.ERROR);
            put(Token.WORD, State.PROGRAM);
            put(Token.VARIABLE, State.ASSIGNMENT);
            put(Token.DOUBLE, State.DOUBLE_QUOTES);
        }});
        put(State.PROGRAM, new HashMap<>() {{
            put(Token.PIPE1, State.START);
            put(Token.WORD, State.CLI);
            put(Token.VARIABLE, State.CLI);
            put(Token.DOUBLE, State.DOUBLE_QUOTES);
        }});
        put(State.CLI, new HashMap<>() {{
            put(Token.PIPE1, State.START);
            put(Token.WORD, State.CLI);
            put(Token.VARIABLE, State.CLI);
            put(Token.DOUBLE, State.CLI);
        }});

        put(State.ASSIGNMENT, new HashMap<>() {{
            put(Token.VARIABLE, State.ASSIGNMENT);
            put(Token.WORD, State.START);
            put(Token.PIPE1, State.START);
            put(Token.DOUBLE, State.START);
        }});

        put(State.DOUBLE_QUOTES, new HashMap<>() {{
            put(Token.DOUBLE, State.DOUBLE_QUOTES);
            put(Token.VARIABLE, State.CLI);
            put(Token.WORD, State.CLI);
            put(Token.PIPE1, State.START);
        }});
    }};


    public ParseResult parseInput(String input) throws UnexpectedTokenException {
        StringBuilder tokenPatternsBuffer = new StringBuilder();
        for (Token token : Token.values())
            tokenPatternsBuffer.append(String.format("|(?<%s>%s)", token.name(), token.pattern));
        Pattern tokenPatterns = Pattern.compile(tokenPatternsBuffer.substring(1));

        Matcher matcher = tokenPatterns.matcher(input);
        int position = 0;
        List<Command> commands = new ArrayList<>();
        List<String> assignments = new ArrayList<>();
        List<String> doubleQuotes = new ArrayList<>();
        Command currentCommand = new Command();
        commands.add(currentCommand);
        State state = State.START;
        while (position < input.length()) {
            if (matcher.find(position)) {
                for (Token token : Token.values()) {
                    if (matcher.group(token.name()) != null) {
                        state = states.get(state).get(token);
                        switch (state) {
                            case START -> {
                                currentCommand = new Command();
                                commands.add(currentCommand);
                                assignments.clear();
                            }

                            case ASSIGNMENT -> {
                                commands.clear();
                                assignments.add(matcher.group(token.name()));
                            }

                            case DOUBLE_QUOTES -> {
                                doubleQuotes.add(matcher.group(token.name()));
                            }

                            case PROGRAM -> {
                                currentCommand.setName(matcher.group(token.name()));
                            }
                            case CLI -> {
                                currentCommand.arguments.add(matcher.group(token.name()));
                            }
                            case ERROR -> {
                                throw new UnexpectedTokenException("Unexpected token near " + matcher.group(token.name()));
                            }
                        }

                    }
                }
                position = matcher.end();
            } else {
                throw new IllegalStateException("UnknownTokenBegin");
            }
        }

        return new ParseResult(assignments, commands, doubleQuotes);
    }
}
