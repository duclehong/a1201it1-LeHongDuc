package exercise;


import java.util.Scanner;

public class MainOptinal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter decimal: ");
        int decNum = sc.nextInt();
        System.out.println("Binary: " + new OptionalConvert().convert(decNum));
    }

}
