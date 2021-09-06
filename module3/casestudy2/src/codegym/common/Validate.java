package codegym.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Validate {
    public static Date strToDate(String str) throws ParseException {
      return new SimpleDateFormat("dd/MM/yyyy").parse(str);
    }
}
