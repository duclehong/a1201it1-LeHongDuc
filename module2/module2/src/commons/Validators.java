package commons;

import exceptions.*;
import java.time.Year;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validators {
    public static final String SERVICES_CODE_REGEX = "SV(VL|HO|RO)-[\\d]{4}";
    public static final String VILLA_CODE_REGEX = "SVVL-[\\d]{4}";
    public static final String SERVICE_NAME_REGEX = "[A-Z][a-z]*";
    public static final String CUSTOMER_EMAIL_REGEX = "[\\w]+@\\w+\\.\\w+";
    public static final String CUSTOMER_ID_REGEX = "\\d{3} \\d{3} \\d{3}";
    public static final String CUSTOMER_DAY_BIRTH_REGEX = "\\d{2}/\\d{2}/\\d{4}";
    private static Pattern pattern;
    private static Matcher matcher;

    public static boolean isValidators(String str, String regex) {
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(str);

        boolean flag = matcher.matches();
        if (!flag) {
            System.out.println("Input not matching" + regex);
        }
        return flag;
    }

    public static boolean isMoreThan(double number, double destNumber) {
        boolean flag = number > destNumber;
        if (!flag) {
            System.out.println("Input not more than" + destNumber);
        }
        return flag;
    }

    public static boolean isMoreThan(double number, double startNumber, double endNumber) {
        boolean flag = number > startNumber && number < endNumber;
        if (!flag) {
            System.out.println("Input not in (" + startNumber + ", " + endNumber + ")");
        }
        return flag;
    }

    public static boolean isValiExtraServiceName(String extraServiceName) {
        String[] arrName = {"massage", "karaoke", "food", "drink", "car"};
        boolean flag = Arrays.asList(arrName).contains("massage");
        System.out.println(flag);
        flag = Arrays.asList(arrName).contains(extraServiceName);
        System.out.println(flag);
        if (!flag) {
            System.out.println("Extra service is not in list service");
        }
        return flag;
    }

    public static boolean checkNameCustomer(String name) throws NameException {
        String[] nameCut = name.split(" ");
        for (String cutString : nameCut) {
            if (Character.isLowerCase(cutString.charAt(0))) {
                throw new NameException();
            }
        }
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) == ' ' && name.charAt(i + 1) == ' ') {
                throw new NameException();
            }
        }
        return true;
    }

    public static boolean checkEmailCustomer(String email) throws EmailException {
        pattern = Pattern.compile(CUSTOMER_EMAIL_REGEX);
        matcher = pattern.matcher(email);
        boolean flag = matcher.matches();
        if (!flag) {
            throw new EmailException();
        }
        return flag;
    }

    public static boolean checkIdCustomer(String email) throws IdCardException {
        pattern = Pattern.compile(CUSTOMER_ID_REGEX);
        matcher = pattern.matcher(email);
        boolean flag = matcher.matches();
        if (!flag) {
            throw new IdCardException();
        }
        return flag;
    }

    public static boolean checkGenderCustomer(String gender) throws GenderException {
        String[] listGender = {"male", "famale", "unknow"};
        boolean flag = Arrays.asList(listGender).contains(gender.toLowerCase());
        if (!flag) {
            throw new GenderException();
        }
        return flag;
    }

    public static boolean checkDayBirthCustomer(String dayBirth) throws BirthdayException {
        pattern = Pattern.compile(CUSTOMER_DAY_BIRTH_REGEX);
        matcher = pattern.matcher(dayBirth);
        boolean flag = matcher.matches();
        if (flag){
            int year = Year.now().getValue();
            int yearBirth = Integer.parseInt(dayBirth.substring(6));
            flag = yearBirth > 1900 && yearBirth < (year - 18);
            if (!flag) {
                throw new BirthdayException();
            }
        }else{
            throw new BirthdayException();
        }
        return flag;
    }
}
