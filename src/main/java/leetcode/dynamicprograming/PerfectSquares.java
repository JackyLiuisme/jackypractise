package leetcode.dynamicprograming;

import java.util.Arrays;

public class PerfectSquares {
    public int numSquares(int n) {
        int [] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 1;
        for (int i = 1; i <= n; i++){
            int min = Integer.MAX_VALUE;
            int j = 1;
            while (i - j * j >=0) {
                min = Math.max(dp[i-j*j] + 1,min);
                j++;
            }
            dp[i] = min;
        }
        return dp[n];
    }
}
