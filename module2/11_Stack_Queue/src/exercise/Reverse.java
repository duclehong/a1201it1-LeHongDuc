package exercise;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Reverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Chon chuc nang: \n- 1: Dao so trong mang \n- 2: Dao chuoi ");
        int selection = scanner.nextInt();
        scanner.nextLine();
        switch (selection) {
            case 1:
                ArrayList<Integer> arrayListInteger = new ArrayList<>();
                Stack<Integer> intergerList = new Stack();
                reverserInteger(scanner, arrayListInteger, intergerList);
                break;
            case 2:
                Stack<Character> charsStack = new Stack();
                reverserString(scanner, charsStack);
                break;

        }
    }

    private static void reverserInteger(Scanner scanner, ArrayList<Integer> arrayList, Stack<Integer> intergerList) {
        System.out.print("Nhap so phan tu trong mang: ");
        int sizeArray = scanner.nextInt();
        for (int i = 0; i < sizeArray; i++) {
            System.out.println("Nhap phan tu thu: " + i);
            int element = scanner.nextInt();
            arrayList.add(element);
        }
        System.out.println("Day so ban dau: " + arrayList.toString());
        for (int i = 0; i < arrayList.size(); i++) {
            intergerList.add(arrayList.get(i));
        }
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.set(i, intergerList.pop());
        }
        System.out.println("Day so dao nguoc: " + arrayList.toString());
    }

    private static void reverserString(Scanner scanner, Stack<Character> charsStack) {
        System.out.println("Nhap chuoi can dao nguoc:");
        String string = scanner.nextLine();
        for (int i = 0; i < string.length(); i++) {
            charsStack.add(string.charAt(i));
        }
        String stringRecerse = "";
        for (int i = 0; i < string.length(); i++) {
            stringRecerse += charsStack.pop();
        }
        System.out.println(stringRecerse);
    }

}
