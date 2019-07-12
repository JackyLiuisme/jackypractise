package offer;

public class testTreeNodeReverse {

    public static int knapSack(int[] w, int[] v, int C) {
        int size = w.length;
        int [] dp = new int[C+1];
        for (int i = 0; i < size; i++){
            for (int j = C; j >= w[i]; j--){
                dp[j] = Math.max(dp[j-1],dp[j-w[i]] + v[i]);
            }
        }
        return dp[C];
    }

    public static void main(String[] args) {
        int[] w = {2, 1, 3, 2};
        int[] v = {12, 10, 20, 15};
        System.out.println(knapSack(w, v, 5));
    }

}
