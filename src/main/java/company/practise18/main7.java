package company.practise18;

import java.util.Arrays;
import java.util.Scanner;

public class main7 {
    // 25  5 , 40, 10
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] array = new int[n];
        for (int i = 0; i < n; i++){
            array[i] = scanner.nextInt();
        }
      //  System.out.println(args[0] + " " + args[1]);

        Arrays.sort(array);
        int max = n-1,min = 0;
        int sum = array[max] - array[min];
        int left = 1,right = n-2;
        while (right > left){
            sum += array[max] - array[left++];
            max--;
            sum += array[right--] - array[min];
            min++;
        }
        if (right == left){
            sum +=  Math.max(array[max] - array[left],array[left] - array[min]);
        }
        System.out.println(sum);

    }
}
