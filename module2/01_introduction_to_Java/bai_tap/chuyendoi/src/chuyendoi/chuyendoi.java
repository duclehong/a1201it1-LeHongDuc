package chuyendoi;

import java.util.Scanner;

public class chuyendoi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap so can in");
        int i = scanner.nextInt();
        if (i >= 0 && i < 10) {
            switch(i) {
                case 0:
                    System.out.println("Không");
                    break;
                case 1:
                    System.out.println("Một");
                    break;
                case 2:
                    System.out.println("Ba");
                case 3:
                default:
                    break;
                case 4:
                    System.out.println("Bốn");
                    break;
                case 5:
                    System.out.println("Năm");
                    break;
                case 6:
                    System.out.println("Sáu");
                    break;
                case 7:
                    System.out.println("Bảy");
                    break;
                case 8:
                    System.out.println("Tám");
                    break;
                case 9:
                    System.out.println("Chín");
                    break;
                case 10:
                    System.out.println("Mười");
            }
        }

        String s1 = null;
        String s2 = null;
        String s;
        char i1;
        char i2;
        int so_hai;
        if (i > 19 && i < 100) {
            s = Integer.toString(i);
            i1 = s.charAt(0);
            i2 = s.charAt(1);
            so_hai = Integer.parseInt(String.valueOf(i1));
            so_hai = Integer.parseInt(String.valueOf(i2));
            s1 = "";
            s2 = "";
            switch(so_hai) {
                case 0:
                    s1 = "Không";
                    break;
                case 1:
                    s1 = "Một";
                    break;
                case 2:
                    s1 = "Hai";
                    break;
                case 3:
                    s1 = "Ba";
                    break;
                case 4:
                    s1 = "Bốn";
                    break;
                case 5:
                    s1 = "Năm";
                    break;
                case 6:
                    s1 = "Sáu";
                    break;
                case 7:
                    s1 = "Bảy";
                    break;
                case 8:
                    s1 = "Tám";
                    break;
                case 9:
                    s1 = "Chín";
            }

            switch(so_hai) {
                case 0:
                    s2 = "";
                    break;
                case 1:
                    s2 = "Một";
                    break;
                case 2:
                    s2 = "Hai";
                    break;
                case 3:
                    s2 = "Ba";
                    break;
                case 4:
                    s2 = "Bốn";
                    break;
                case 5:
                    s2 = "Lăm";
                    break;
                case 6:
                    s2 = "Sáu";
                    break;
                case 7:
                    s2 = "Bảy";
                    break;
                case 8:
                    s2 = "Tám";
                    break;
                case 9:
                    s2 = "Chín";
            }
        }

        if (i > 9 && i < 20) {
            s = Integer.toString(i);
            i1 = s.charAt(0);
            i2 = s.charAt(1);
            so_hai = Integer.parseInt(String.valueOf(i2));
            s1 = "Mười";
            s2 = "";
            switch(so_hai) {
                case 0:
                    s2 = "";
                    break;
                case 1:
                    s2 = "Một";
                    break;
                case 2:
                    s2 = "Hai";
                    break;
                case 3:
                    s2 = "Ba";
                    break;
                case 4:
                    s2 = "Bốn";
                    break;
                case 5:
                    s2 = "Lăm";
                    break;
                case 6:
                    s2 = "Sáu";
                    break;
                case 7:
                    s2 = "Bảy";
                    break;
                case 8:
                    s2 = "Tám";
                    break;
                case 9:
                    s2 = "Chín";
            }
        }

        if (i > 9 && i < 20) {
            System.out.println(s1 + " " + s2);
        } else {
            System.out.println(s1 + " Mươi " + s2);
        }

    }
}
