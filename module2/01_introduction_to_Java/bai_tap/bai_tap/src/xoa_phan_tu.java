import java.util.Scanner;

public class xoa_phan_tu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số phần tử: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        nhapMang(arr,sc);
//        xuatMang(arr);
        xoaMang(arr,sc);

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
    public static int checkMang(int arr[], int a){
        int c = 0;
        for (int i = 0; i <arr.length ; i++) {

            if (arr[i] == a){
                c+=1;
            }
        }
        return c;
    }
    public static void xoaMang(int arr[], Scanner sc){
        System.out.println("Nhập giá trị cần xóa: ");
        int a = sc.nextInt();
        int arr2[] = new int[arr.length-checkMang(arr, a)];
        int j = 0 ;
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i] != a){
                System.out.println(j);
                arr2[j]= arr[i];
                j++;
            }
        }
        System.out.println("Mảng ban đầu: ");
        xuatMang(arr);
        System.out.println("Mảng sau khi xóa phần tử có giá trị =  " + a + ":");
        xuatMang(arr2);
    }
}
