package exceptions;

public class EmailException extends Exception {
    public EmailException() {
        super("Email must be true format abc@abc.abc");
    }
}
