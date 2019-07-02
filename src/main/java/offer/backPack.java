package offer;
/**
 * 5 8
 * 3 5 1 2 2
 * 4 5 2 1 3
 */

import java.util.Scanner;

public class backPack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int V = scanner.nextInt();
        int[] weight = new int[n+1];
        int [] dp = new int[V+1];
        int [] c = new int[n+1];
        for (int i = 1; i <= n; i++){
            weight[i] = scanner.nextInt();
        }
        for (int i = 1; i <= n; i++){
            c[i] = scanner.nextInt();
        }
        for (int i = 1; i <= V; i++){
            dp[i] = 0;
        }
        for (int i = 1; i <= n; i++){
            for (int v = V; v >= weight[i]; v--){
                dp[v] = Math.max(dp[v],dp[v-weight[i]] + c[i] );
            }
        }
        int result = 0;
        for (int i = 0; i <= V; i++){
            result = Math.max(result,dp[i]);
        }
        System.out.println(result);
    }
}
