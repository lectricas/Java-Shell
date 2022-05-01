package parser;

public enum TokenType {
    // Single-character tokens.
    PIPE,
    DOLLAR,
    SPACE,
    EQUAL,
    // Literals.
    WORD,SINGLE_S,DOUBLE_S,VARIABLE,
    // Keywords.
    WC, ECHO, PWD, CAT,
    EOF
}
