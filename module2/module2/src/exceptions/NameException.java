package exceptions;

public class NameException extends Exception{
    public NameException(){
        super("Customer Name must be in the first character in each from");
    }
}
