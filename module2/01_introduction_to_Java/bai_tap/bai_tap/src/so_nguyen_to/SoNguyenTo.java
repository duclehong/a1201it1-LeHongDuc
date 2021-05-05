package so_nguyen_to;

import java.util.Scanner;

public class SoNguyenTo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1 - Hien thi 20 so nguyen to dau tien");
        System.out.println("2 - Hien thi cac so nguyen to be hon 100");
        int in = sc.nextInt();
        switch(in){
            case 1:
                hienThi20();
                break;
            case 2:
                hienThi100();
                break;
        }
    }
    public static void hienThi20(){

       int check =0;
       for(int i = 0; check <20; i++){
           if(checkSoNguyenTo(i)){
               System.out.println(" " + i + " ");
               check++;
           }
       }

    }
    public static void hienThi100(){

        for(int i = 0; i<100; i++){
            if(checkSoNguyenTo(i)){
                System.out.println(" " + i + " ");

            }
        }
    }

    public static boolean checkSoNguyenTo(int n){
        if(n<2){
            return false;
        }
        if(n==2){
            return true;
        }
        for(int i=2; i<n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}
