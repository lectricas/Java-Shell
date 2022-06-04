package parser;

import java.util.HashMap;
import java.util.Map;

public class Environment {

    public static final Map<String, String> values = new HashMap<>();

    public String get(String name) {
        return values.getOrDefault(name, "");
    }

    void define(String name, String value) {
        values.put(name, value);
    }
}
