package leetcode.dynamicprograming;

import java.util.Arrays;

/**
 * 求{1,4,9,16--}等数组成的最小个数
 * 如 17 = 16 + 1； 3 = 1+1+1
 */
public class numSquares {
    public static void main(String[] args) {
        int i = numSquares(17);
        System.out.println(i);
    }
    public static int numSquares(int n){
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++){
            int j = 1;
            int min = Integer.MAX_VALUE;
            while (i - j*j >= 0){
                dp[i] = Math.min(min,dp[i-j*j]+1);
                j++;
            }
        }
        return dp[n];
    }
}
