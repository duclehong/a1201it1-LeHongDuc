package phuongthuc;

import java.util.Scanner;

public class TongDuongCheoChinh {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Nhập số hàng");
        int n = in.nextInt();
        System.out.println("Nhập số hàng");
        int m = in.nextInt();
        int arr1[][] = new int[n][m];
        nhap(arr1,in);
        xuat(arr1,in);
        System.out.println("Tong duong cheo chinh = " + tongCheo(arr1));
    }
    public static int tongCheo(int arr[][]){
        int a = 0;

        for (int i = 0; i < arr.length ; i++) {
            a += arr[i][i];
        }
        return a;
    }
    public static void nhap(int arr[][], Scanner sc){
        for (int i = 0; i < arr.length ; i++) {
            for (int j = 0; j <arr[0].length ; j++) {
                System.out.println("Nhập phần tử ");
                arr[i][j] = sc.nextInt();
            }
        }
    }
    public static void xuat(int arr[][], Scanner sc){
        for (int i = 0; i < arr.length ; i++) {
            for (int j = 0; j <arr[0].length ; j++) {
                System.out.print(arr[i][j] + " ");

            }
            System.out.println("");
        }
    }
}
