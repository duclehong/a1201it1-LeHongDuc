import java.util.Scanner;
import java.util.SplittableRandom;

public class main {
    public static String chuyendoi(int i){

        if (i >= 0 && i < 10) {
            switch (i) {
                case 0:
                    return ("");
                case 1:
                    return ("Linh Một");
                case 2:
                    return ("Linh Hai");
                case 3:
                    return ("Linh Ba");
                case 4:
                    return ("Linh Bốn");
                case 5:
                    return ("Linh Năm");
                case 6:
                    return ("Linh Sáu");
                case 7:
                    return ("Linh Bảy");
                case 8:
                    return ("Linh Tám");
                case 9:
                    return ("Linh Chín");


                default:
                    break;
            }
        }
        String s1 = null;
        String s2 = null;
        if (i > 19 && i < 100) {
            String s = Integer.toString(i);
            char i1 = s.charAt(0);
            char i2 = s.charAt(1);
            int so_dau = Integer.parseInt(String.valueOf(i1));
            int so_hai = Integer.parseInt(String.valueOf(i2));
            s1 = "";
            s2 = "";
            switch (so_dau) {
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
                    break;

                default:
                    break;
            }
            switch (so_hai) {
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
                    break;

                default:
                    break;
            }
        }
        if (i > 9 && i < 20) {
            String s = Integer.toString(i);
            char i1 = s.charAt(0);
            char i2 = s.charAt(1);
            int so_hai = Integer.parseInt(String.valueOf(i2));
            s1 = "Mười";
            s2 = "";

            switch (so_hai) {
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
                    break;

                default:
                    break;
            }
        }
        if (i > 9 && i < 20){

            String c = s1 + " " + s2;
            return c;
        }else {
            String c = s1 + " Mươi " + s2;
            return c;
        }

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap so can in");

        int i = scanner.nextInt();

        if (i >= 0 && i < 10) {
            switch (i) {
                case 0:
                    System.out.println("Không");
                    break;
                case 1:
                    System.out.println("Một");
                    break;
                case 2:
                    System.out.println("Ba");
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
                    break;

                default:
                    break;
            }
        }
        String s1 = null;
        String s2 = null;
        if (i > 19 && i < 100) {
            String s = Integer.toString(i);
            char i1 = s.charAt(0);
            char i2 = s.charAt(1);
            int so_dau = Integer.parseInt(String.valueOf(i1));
            int so_hai = Integer.parseInt(String.valueOf(i2));
            s1 = "";
            s2 = "";
            switch (so_dau) {
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
                    break;

                default:
                    break;
            }
            switch (so_hai) {
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
                    break;

                default:
                    break;
            }
        }
        if (i > 9 && i < 20) {
            String s = Integer.toString(i);
            char i1 = s.charAt(0);
            char i2 = s.charAt(1);
            int so_hai = Integer.parseInt(String.valueOf(i2));
            s1 = "Mười";
            s2 = "";

            switch (so_hai) {
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
                    break;

                default:
                    break;
            }
        }
        if (i > 9 && i < 20){
            System.out.println(s1 + " " + s2);
        }
        if(i>19&&i<100){
            System.out.println(s1 + " Mươi " + s2);
        }
        if (i > 99 && i < 1000) {
            String s = Integer.toString(i);
            char i1 = s.charAt(0);
            char i2 = s.charAt(1);
            String st = s.substring(1,3);
            int s12 = Integer.parseInt(String.valueOf(st));
            int i01 = Integer.parseInt(String.valueOf(i1));

//
            switch (i01) {

                case 1:
                    System.out.println("Một Trăm " + chuyendoi(s12));
                    break;
                case 2:
                    System.out.println("Hai Trăm " + chuyendoi(s12));
                    break;
                case 3:
                    System.out.println("Ba Trăm " + chuyendoi(s12));
                    break;
                case 4:
                    System.out.println("Bốn Trăm " + chuyendoi(s12));
                    break;
                case 5:
                    System.out.println("Năm Trăm " + chuyendoi(s12));
                    break;
                case 6:
                    System.out.println("Sáu Trăm " + chuyendoi(s12));
                    break;
                case 7:
                    System.out.println("Bảy Trăm " + chuyendoi(s12));
                    break;
                case 8:
                    System.out.println("Tám Trăm " + chuyendoi(s12));
                    break;
                case 9:
                    System.out.println("Chín Trăm " + chuyendoi(s12));
                    break;

                default:
                    break;
            }
        }

    }


}

