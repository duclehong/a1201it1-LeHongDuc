import java.util.Scanner;

public class GopMang {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Nhập số lượng phần tử mảng thứ nhất");
        int n = in.nextInt();
        int arr1[] = new int[n];
        nhapMang(arr1, in);
        System.out.println("Nhập số lượng phần tử mảng thứ hai");
        int m = in.nextInt();
        int arr2[] = new int[m];
        nhapMang(arr2, in);
        them(arr1,arr2,in);

    }
    public static void nhapMang(int arr[], Scanner sc){
        for (int i = 0; i <arr.length ; i++) {
            System.out.println("Nhập phần tử thứ: " + i);
            arr[i] = sc.nextInt();
        }
    }
    public static void xuatMang(int arr[]){
        for (int i = 0; i <arr.length ; i++) {
            System.out.println("Phần tử thứ " + i + ": " + arr[i] );
        }
    }
    public static void them(int[] arr1, int[] arr2, Scanner sc){

        int[] arr3 = new  int[arr1.length+arr2.length];
        for (int i = 0; i <arr1.length ; i++) {
            arr3[i]=  arr1[i];

        }
        int n = arr1.length;
        for (int i = 0; i <arr2.length ; i++) {
            arr3[n]=  arr2[i];
            n++;

        }
        xuatMang(arr3);
    }
}
