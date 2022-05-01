package parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static parser.TokenType.*;

public class Scanner {
    private final String source;
    private final List<Token> tokens = new ArrayList<>();
    private int start = 0;
    private int current = 0;
    private int line = 1;

    private static final Map<String, TokenType> keywords;

    static {
        keywords = new HashMap<>();
        keywords.put("wc", WC);
        keywords.put("echo", ECHO);
        keywords.put("pwd", PWD);
        keywords.put("cat", CAT);
    }

    public Scanner(String source) {
        this.source = source;
    }

    public List<Token> scanTokens() {
        while (!isAtEnd()) {
            start = current;
            scanToken();
        }

        tokens.add(new Token(EOF, null, null));
        return tokens;
    }

    private void scanToken() {
        char c = advance();
        switch (c) {
            case '|':
                while (peek() == ' ' && !isAtEnd()) advance();
                tokens.add(new Token(PIPE));
                break;
            case '=':
                tokens.add(new Token(EQUAL));
                break;
            case '$':
                identifier();
                break;
            case '"': doubleString(); break;
            case '\'': simpleString(); break;
            case ' ':
                while (peek() == ' ' && !isAtEnd()) advance();
                if (match('|')) {
                    while (peek() == ' ' && !isAtEnd()) advance();
                    tokens.add(new Token(PIPE));
                } else {
                    tokens.add(new Token(SPACE));
                }
                break;
            case '\r':
            case '\t':
                break;
            case '\n':
                line++;
                break;
            default:
                if (isAlphaNumeric(c)) {
                    identifier();
                } else {
                    Bash.error("Unexpected character: " + c);
                }
                break;
        }
    }

    private void identifier() {
        while (isAlphaNumeric(peek())) advance();
        String text = source.substring(start, current);
        TokenType type = keywords.get(text);
        if (type == null) type = WORD;
        addToken(type, text);
    }

    private char peek() {
        if (isAtEnd()) return '\0';
        return source.charAt(current);
    }

    private boolean isAlpha(char c) {
        return (c >= 'a' && c <= 'z') ||
                (c >= 'A' && c <= 'Z') ||
                c == '_' || c == '-';
    }

    private void doubleString() {
        while (peek() != '"' && !isAtEnd()) {
            if (peek() == '\n') line++;
            advance();
        }

        // Unterminated string.
        if (isAtEnd()) {
            Bash.error("Unterminated string.");
            return;
        }

        // The closing ".
        advance();

        // Trim the surrounding quotes.
        String value = source.substring(start + 1, current - 1);
        Scanner s1 = new Scanner(value);
        addToken(DOUBLE_S, value, s1.scanTokens());
    }

    private void simpleString() {
        while (peek() != '\'' && !isAtEnd()) {
            if (peek() == '\n') line++;
            advance();
        }

        // Unterminated string.
        if (isAtEnd()) {
            Bash.error("Unterminated string.");
            return;
        }

        // The closing ".
        advance();

        // Trim the surrounding quotes.
        String value = source.substring(start + 1, current - 1);
        addToken(SINGLE_S, value);
    }

    private boolean match(char expected) {
        if (isAtEnd()) return false;
        if (source.charAt(current) != expected) return false;

        current++;
        return true;
    }

    private boolean isAlphaNumeric(char c) {
        return isAlpha(c) || isDigit(c);
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    private boolean isAtEnd() {
        return current >= source.length();
    }

    private char advance() {
        current++;
        return source.charAt(current - 1);
    }

    private void addToken(TokenType type) {
        addToken(type, null);
    }

    private void addToken(TokenType type, String literal, List<Token> ifString) {
        String text = source.substring(start, current);
        Token tok = new Token(type, text, literal);
        tok.ifString = ifString;
        tokens.add(tok);
    }

    private void addToken(TokenType type, String literal) {
        String text = source.substring(start, current);
        tokens.add(new Token(type, text, literal));
    }
}