package exceptions;

public class BirthdayException extends Exception{
    public BirthdayException(){
        super("Birth year must be >1900 and 18 years less than current year, correct format dd/mm/yyyy");
    }
}
