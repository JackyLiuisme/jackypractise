package leetcode;

public class LengthOfList300 {
    public static void main(String[] args) {
        int [] nums = {10,9,2,5,3,7, 1,101,18};
        int i = lengthOfLIS(nums);
        System.out.println(i);
    }
    public  static int lengthOfLIS(int[] nums){
        int [] dp = new int[nums.length];
        dp[0] =1;
        int max = 0;
        for (int i = 0; i < nums.length; i++){
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {

                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
            max = Math.max(dp[i],max);
        }
        return max;
    }
}
