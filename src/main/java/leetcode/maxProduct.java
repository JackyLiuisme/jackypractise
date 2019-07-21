package leetcode;

/**
 * q求数组的子序列的最大乘积是多少
 *
 */
public class maxProduct {
    public static void main(String[] args) {
        int [] nums = {-2,3,-1,4};
        int i = maxProduct(nums);
        System.out.println(i);
    }
    public static int maxProduct(int [] nums){
        int [] dp = new int[nums.length];
        int result = 0;
        for (int i = 0; i < nums.length; i++){
            int temp = 1;
            for (int j = i; j >=  0 ; j--){
                temp *= nums[j];
                dp[i] = Math.max(temp,dp[i]);
            }
            result = Math.max(result,dp[i]);
        }
        return result;
    }
}
