package company.practise18;

import java.util.Scanner;

public class meitua2019d {
    public static void main(String[] args) {
        int n,cost ;

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        cost  = scanner.nextInt();
        int dp[] = new int[100+cost];
        dp[0] = 1;
        for (int i = 0; i < n; i++){
            int temp = scanner.nextInt();
            for (int j =99 +cost; j >= temp; j--){
                dp[j] += dp[j-temp];
            }
        }
        for (int i = cost; i < 100+cost; i++){
            if (dp[i] != 0){
                System.out.println(i);
                break;
            }
        }
    }
}
