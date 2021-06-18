package Excercise;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidateClassName {
    public static void main(String[] args) {
        final String REGEX_NAME_CLASS = "[C,A,P]\\d{4}[G,H,I,K,L,M]";
        Scanner scanner = new Scanner(System.in);
        String nameClass = null;
        do {
            System.out.println("Enter name class");
            nameClass = scanner.nextLine();
        }while (nameClass.matches(REGEX_NAME_CLASS)!=true);
        System.out.println("Accept!");
    }
}
