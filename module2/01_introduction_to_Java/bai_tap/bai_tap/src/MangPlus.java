import java.util.Scanner;

public class MangPlus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số phần tử trong mảng: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        nhapMang(arr,scanner);
        them(arr,scanner);
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
    public static void them(int[] arr, Scanner sc){
        System.out.println("Nhập giá trị cần thêm: ");
        int a = sc.nextInt();
        int[] arr2 = new  int[arr.length+1];
        for (int i = 0; i <arr2.length ; i++) {
            if (i==(arr2.length-1)){
                arr2[i] = a;
                break;
            }
            arr2[i]=  arr[i];

        }
        xuatMang(arr2);
    }
}
