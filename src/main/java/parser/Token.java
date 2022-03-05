package parser;

//order is important
enum Token {
    PIPE1("\\|"),
    WORD("[^\\s]+");
    final String pattern;

    Token(String pattern) {
        this.pattern = pattern;
    }
}
