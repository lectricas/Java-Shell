package parser;

public class UnexpectedTokenException extends Exception{
    public UnexpectedTokenException(String message) {
        super(message);
    }
}
