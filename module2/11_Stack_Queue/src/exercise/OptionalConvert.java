package exercise;

import java.util.Scanner;
import java.util.Stack;

public class OptionalConvert {
    public String convert(int decimal) {
        Stack<Integer> binStack = new Stack<>();
        StringBuilder binary = new StringBuilder();
        while (decimal != 0) {
            binStack.push(decimal % 2);
            decimal = decimal / 2;
        }
        while (!binStack.isEmpty()) {
            binary.append(binStack.pop());
        }
        return String.valueOf(binary);
    }


}
