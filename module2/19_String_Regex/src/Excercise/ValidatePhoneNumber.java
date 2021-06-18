package Excercise;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidatePhoneNumber {
    public static void main(String[] args) {
        final String REGEX_PHONE_NUMBER = "^((\\(\\d{2}\\))|\\d{2})[-]((\\([0]\\d{9}\\))|[0]\\d{9})";

        Pattern p = Pattern.compile(REGEX_PHONE_NUMBER);
        Scanner scanner = new Scanner(System.in);
        String phoneNumber = null;
        do {
            System.out.println("Enter phone number");
            phoneNumber = scanner.nextLine();
        }while (p.matcher(phoneNumber).matches()!=true);
        System.out.println("Accept!");
    }
}
