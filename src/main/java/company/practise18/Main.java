package company.practise18;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int n = Integer.valueOf(s);
        int [] nums = new int[n];
        for (int i = 0; i < n ; i++){
            nums[i] = scanner.nextInt();
        }
        Arrays.sort(nums);
        boolean flag = false;
        int distance = nums[1] - nums[0];
        for (int i = 2; i < n; i++){
            if (nums[i] - nums[i-1] != distance){
                System.out.printf("Impossible\n");
                flag = true;
                break;
            }
        }
        if (!flag){
            System.out.printf("Possible\n");
        }
    }
}
