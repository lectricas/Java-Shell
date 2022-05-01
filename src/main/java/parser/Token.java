package parser;

import java.util.List;
import java.util.Objects;

public class Token {
    public final TokenType type;
    public final String rawText;
    public final String literal;

    public List<Token> ifString;

    Token(TokenType type, String rawText, String literal) {
        this.type = type;
        this.rawText = rawText;
        this.literal = literal;
    }

    Token(TokenType type) {
        this.type = type;
        this.rawText = null;
        this.literal = null;
    }

    public String toString() {
        return type + " " + rawText + " " + literal + " " + ifString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Token token = (Token) o;
        return type == token.type && Objects.equals(rawText, token.rawText) && Objects.equals(literal, token.literal) && Objects.equals(ifString, token.ifString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, rawText, literal, ifString);
    }
}
