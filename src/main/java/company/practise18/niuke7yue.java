package company.practise18;

import java.util.Scanner;

public class niuke7yue {

    int n, k;
   static   int dp[][] = new int[55][1005];
    public static void main(String[] args) {
      //  final int mod = 1e9 + 7;

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        dp[0][0] = 1;
        for(int i = 0; i < n; i++) {
            for(int j = k; j >= 1; j--) {
                for(int x = 0; x < n; x++) {
                    dp[j][x] = (dp[j][x] + dp[j - 1][x - i < 0 ? x - i + n : x - i])%100000007;
                }
            }
        }

        System.out.println(dp[k][0]);
    }
}
