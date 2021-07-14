package exceptions;

public class IdCardException extends Exception {
    public IdCardException(){
        super("Id Card must have 9 digits and in the format XXX XXX XXX");
    }
}
