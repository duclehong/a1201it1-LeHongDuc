package ve_hinh_sao;

import java.util.Scanner;

public class Hinh {
    public static void ve_chu_nhat(int i, int j){
        for (int a =0; a<i; a++){
            System.out.println("");
            for (int b = 0; b<j;b++){
                System.out.print("*");
            }
        }
    }
    public static  void  bottonleft(){
        for(int i = 0 ; i< 5; i++){
            for (int j = 0; j<=i;j++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }
    public static  void  topleft(){
        for(int i = 0 ; i< 5; i++){
            for (int j = 5; j>i;j--){
                System.out.print("*");
            }
            System.out.println("");
        }
    }
    public static  void  tamgiaccan(){
        for(int i = 0 ; i<= 5; i++){
            for (int j = 5; j>i;j--){
                System.out.print(" ");
            }

            for (int j = 0; j<(2*i-1);j++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        System.out.println("Nhập lệnh");
        System.out.println("1 - vẽ hình chữ nhật");
        System.out.println("2 - bot left ");
        System.out.println("3 - top left");
        System.out.println("4 - tam giac can");

        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        switch (i){
            case 1:
                System.out.println("nhap chieu doc");
                int doc = sc.nextInt();
                System.out.println("nhap chieu ngang");
                int ngang = sc.nextInt();
                ve_chu_nhat(doc, ngang);
            case 2:
                bottonleft();
            case 3:
                topleft();
            case 4:
                tamgiaccan();

        }

    }
}
