package chuyen_doi;


import java.util.Scanner;

public class TienTe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tỷ giá: ");
        float rate = scanner.nextFloat();
        System.out.println("Nhập giá trị USD");
        int USD = scanner.nextInt();
        float VND = rate*USD;
        int v = Math.round(VND);
        System.out.println("Quy đổi " + USD + " USD ra VND là: " + v);

    }
}
