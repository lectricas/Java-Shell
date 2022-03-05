package builtins;

public class NoSuchFileException extends Exception{
    public NoSuchFileException(String message) {
        super(message);
    }
}