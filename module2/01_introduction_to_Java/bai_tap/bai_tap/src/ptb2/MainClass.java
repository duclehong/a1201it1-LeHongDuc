package ptb2;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap a: ");
        float a = scanner.nextFloat();
        System.out.println("nhap b: ");
        float b = scanner.nextFloat();
        System.out.println("nhap c: ");
        float c = scanner.nextFloat();

        PhuongTrinhBacHai d = new PhuongTrinhBacHai(a,b,c);
        if(d.getDiscriminant()>=0){
            System.out.println("Phương trình có 2 nghiệm: " + d.getRoot1() + " và " + d.getRoot2());

        }else{
            System.out.println("Pt vô nghiệm!" );

        }
    }
}
