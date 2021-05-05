package so_sang_chu;

import java.util.Scanner;

public class SoSangChu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số cần chuyển đổi");
        int n = sc.nextInt();
        if (n < 10) {
            System.out.println(behon10(n));
            ;
        } else if (n > 9 && n < 20) {
            System.out.println(muoidenhaimuoi(n));
        } else if (n > 19 && n < 100) {
            System.out.println(haichuso(n));
        } else if(n>99){
            System.out.println(bachuso(n));
        }
    }

    public static String muoidenhaimuoi(int a) {
        int b = a - 10;
        if (b == 0) {
            return "Mười";
        } else {
            return "Mười " + hauto(b);
        }

    }

    public static String behon10(int a) {
        switch (a) {
            case 0:
                return "Không";
            case 1:
                return "Một";
            case 2:
                return "Hai";
            case 3:
                return "Ba";
            case 4:
                return "Bốn";
            case 5:
                return "Năm";
            case 6:
                return "Sáu";
            case 7:
                return "Bảy";
            case 8:
                return "Tám";
            case 9:
                return "Chín";
        }
        return "";
    }

    public static String hauto(int a) {
        switch (a) {
            case 0:
                return "Không";
            case 1:
                return "Một";
            case 2:
                return "Hai";
            case 3:
                return "Ba";
            case 4:
                return "Bốn";
            case 5:
                return "Lăm";
            case 6:
                return "Sáu";
            case 7:
                return "Bảy";
            case 8:
                return "Tám";
            case 9:
                return "Chín";
        }
        return "";
    }

    public static String haichuso(int a) {
        String b = Integer.toString(a);
        String b0 = b.substring(0, 1);
        String b1 = b.substring(1, 2);
        int number1 = Integer.parseInt(b0);
        int number2 = Integer.parseInt(b1);
        if (number2 ==0){
            return behon10(number1) + " Mươi";
        }
        return behon10(number1) + " Mươi " + hauto(number2);
    }
    public static String bachuso(int a) {
        String b = Integer.toString(a);
        String b0 = b.substring(0, 1);
        String b1 = b.substring(1, 3);
        int number1 = Integer.parseInt(b0);
        int number2 = Integer.parseInt(b1);
        String hauto = null;
        if (number2==0){
            hauto = "";
        } else if (number2<10){

            hauto = "Linh " + behon10(number2);
        }else if(number2<20){
            hauto = muoidenhaimuoi(number2);
        }else{
            hauto = haichuso(number2);
        }
        return behon10(number1) + " Trăm " + hauto;
    }
}
