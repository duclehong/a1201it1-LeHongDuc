package Triangle;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double a, b, c;
        String color;
        boolean filled;
        do {
            System.out.println("Nhập màu: ");
            color= scanner.nextLine();
            System.out.println("Filled: ");
            filled= scanner.nextBoolean();
            System.out.println("nhập cạnh a:");
            a = scanner.nextDouble();
            System.out.println("nhập cạnh b:");
            b = scanner.nextDouble();
            System.out.println("nhập cạnh c:");
            c = scanner.nextDouble();

        } while (a + b <= c || a + c <= b || b + c <= a);
        Triangle triangle = new Triangle(color, filled, a, b, c);
        System.out.println(triangle.toString());

    }

}
