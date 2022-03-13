package parser;

//order is important
enum Token {
    PIPE1("\\|"),
    DOUBLE("\"([^\"]*)\""),
    VARIABLE("[^\\s]+=[^\\s]+"),
    WORD("[^\\s]+");

    final String pattern;

    Token(String pattern) {
        this.pattern = pattern;
    }
}
