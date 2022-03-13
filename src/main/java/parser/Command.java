package parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Command {
    private String name;
    private Token token;
    List<String> arguments = new ArrayList<>();

    public Command(){

    }

    public Command(String name, List<String> arguments) {
        this.name = name;
        this.arguments = arguments;
    }

//    public void setLeadingToken(Token token) {
//        if (this.token == null) {
//            this.token = token;
//        }
//    }
//
//    public Token getLeadingToken() {
//        return token;
//    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getArguments() {
        return arguments;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Command command = (Command) o;
        return name.equals(command.name) && arguments.equals(command.arguments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, arguments);
    }

    @Override
    public String toString() {
        return "Command{" +
                "name='" + name + '\'' +
                ", arguments=" + arguments +
                '}';
    }
}
