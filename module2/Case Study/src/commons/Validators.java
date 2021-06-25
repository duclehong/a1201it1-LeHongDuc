package commons;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validators {
    public static final String SERVICES_CODE_REGEX = "SV(VL|HO|RO)-[\\d]{4}";
    public static final String VILLA_CODE_REGEX = "SVVL-[\\d]{4}";
    public static final String SERVICE_NAME_REGEX = "[A-Z][a-z]*";
    private static Pattern pattern;
    private static Matcher matcher;
    
    public static boolean isValidators(String str, String regex){
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(str);

        boolean flag = matcher.matches();
        if (!flag){
            System.out.println("Input not matching" + regex);
        }
        return flag;
    }
    public static boolean isMoreThan(double number, double destNumber){
        boolean flag = number > destNumber;
        if (!flag){
            System.out.println("Input not more than" + destNumber);
        }
        return flag;
    }
    public static boolean isMoreThan(double number, double startNumber,double endNumber){
        boolean flag = number > startNumber && number < endNumber;
        if (!flag){
            System.out.println("Input not in (" + startNumber + ", " +endNumber +")");
        }
        return flag;
    }
    public static boolean isValiExtraServiceName(String extraServiceName){
        String[] arrName = {"massage", "karaoke", "food", "drink", "car"};
        boolean flag = Arrays.asList(arrName).contains("massage");
        System.out.println(flag);
        flag = Arrays.asList(arrName).contains(extraServiceName);
        System.out.println(flag);
        if (!flag){
            System.out.println("Extra service is not in list service");
        }
        return flag;
    }
}
