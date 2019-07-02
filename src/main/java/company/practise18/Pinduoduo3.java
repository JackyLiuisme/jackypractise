package company.practise18;

import java.util.Arrays;
import java.util.Scanner;

public class Pinduoduo3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n ; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);    //先对读进来的数组进行自然升序排列
        int[] sum = new int[n/2];
        for(int i = 0; i < n/2; i++) {
            sum[i] = arr[i] + arr[n-1-i];  //然后进行首位相加得到两两配对的和
        }
        Arrays.sort(sum);  //再将存放两个数和的数组进行升序或者降序都行（）
        int min = Math.abs(sum[0] - sum[n/2- 1]);
        System.out.println(min);
    }
}
