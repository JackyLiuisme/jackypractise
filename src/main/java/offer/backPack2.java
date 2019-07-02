package offer;

public class backPack2 {
    public static int knapSack(int[] w, int[] v, int C) {
        int size = w.length;
        if (size == 0) {
            return 0;
        }

        int[][] dp = new int[size][C + 1];
        //初始化第一行
        //仅考虑容量为C的背包放第0个物品的情况
        for (int i = 0; i <= C; i++) {
            dp[0][i] = w[0] <= i ? v[0] : 0;
        }
        //填充其他行和列
        for (int i = 1; i < size; i++) {
            for (int j = 0; j <= C; j++) {
                dp[i][j] = dp[i - 1][j];
                if (w[i] <= j) {
                    dp[i][j] = Math.max(dp[i][j], v[i] + dp[i - 1][j - w[i]]);
                }
            }
        }
        return dp[size - 1][C];
    }

    public static void main(String[] args) {
        int[] w = {2, 1, 3, 2};
        int[] v = {12, 10, 20, 15};
        System.out.println(knapSack(w, v, 5));
    }
}


