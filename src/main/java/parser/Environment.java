package parser;

import java.util.HashMap;
import java.util.Map;

public class Environment {
    final Environment enclosing;
    private final Map<String, String> values = new HashMap<>();

    Environment() {
        enclosing = null;
    }

    Environment(Environment enclosing) {
        this.enclosing = enclosing;
    }

    public String get(String name) {
        return values.getOrDefault(name, "");
    }

//    void assign(Token1 name, Object value) {
//        if (values.containsKey(name.lexeme)) {
//            values.put(name.lexeme, value);
//            return;
//        }
//
//        if (enclosing != null) {
//            enclosing.assign(name, value);
//            return;
//        }
//
//        throw new RuntimeError(name, "Undefined variable '" + name.lexeme + "'.");
//    }

    void define(String name, String value) {
        values.put(name, value);
    }
}
