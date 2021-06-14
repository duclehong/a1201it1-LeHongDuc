package Execirse;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class MaxLength {
    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//
//        // Prompt the user to enter a string
//        System.out.print("Enter a string: ");
//        String string = input.nextLine();
//
//        LinkedList<Character> max = new LinkedList<>();
//
//        // Find the maximum increasingly ordered subsequence
//        for (int i = 0; i < string.length(); i++) {
//            LinkedList<Character> list = new LinkedList<>();
//            list.add(string.charAt(i));
//            for (int j = i + 1; j < string.length(); j++) {
//                if (string.charAt(j) > list.getLast()) {
//                    list.add(string.charAt(j));
//                }
//            }
//
//            if (list.size() > max.size()) {
//                max.clear();
//                max.addAll(list);
//            }
//            list.clear();
//        }
//
//        // Display the maximum consecutive
//        // increasingly ordered substring
//        for (Character ch: max) { // single loop
//            System.out.print(ch); // Simple statement
//        }
//        System.out.println();



        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a String");
        String string = scanner.nextLine();
        String stringDel = string.replaceAll("\\s+","");
        ArrayList<Character> max = new ArrayList<>();
        for (int i = 0; i < stringDel.length(); i++){
            ArrayList<Character> list = new ArrayList<>();
            list.add(stringDel.charAt(i));
            for (int j = i+1; j < stringDel.length(); j++ ){
                if(stringDel.charAt(j)> list.get(list.size()-1)){
                    list.add(stringDel.charAt(j));
                }else{
                    break;
                }
            }
            if(list.size()>max.size()){
                max.clear();
                max.addAll(list);
            }
        }

        for (Character ch: max){
            System.out.print(ch);
        }
    }
//    public static String deleteSpaces(String string){
//        LinkedList<Character> strinngDel = new LinkedList<>();
//        for (int i = 0; i < string.length() ; i++) {
//            if(string.charAt(i) != "A"){
//            }
//        }
//        return "a";
//    }
}
