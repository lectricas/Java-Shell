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
        }});
        put(State.PROGRAM, new HashMap<>() {{
            put(Token.PIPE1, State.START);
            put(Token.WORD, State.CLI);
        }});
        put(State.CLI, new HashMap<>() {{
            put(Token.PIPE1, State.START);
            put(Token.WORD, State.CLI);
        }});
        put(State.ERROR, new HashMap<>() {{
            put(Token.PIPE1, State.ERROR);
            put(Token.WORD, State.PROGRAM);
        }});
    }};


    public List<Command> parseInput(String input) throws UnexpectedTokenException {
        StringBuilder tokenPatternsBuffer = new StringBuilder();
        for (Token token : Token.values())
            tokenPatternsBuffer.append(String.format("|(?<%s>%s)", token.name(), token.pattern));
        Pattern tokenPatterns = Pattern.compile(tokenPatternsBuffer.substring(1));

        Matcher matcher = tokenPatterns.matcher(input);
        int position = 0;
        List<Command> commands = new ArrayList<>();
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
                            }

                            case PROGRAM -> {
                                currentCommand.name = matcher.group(token.name());
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
        return commands;
    }
}
