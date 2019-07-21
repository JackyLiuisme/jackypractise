package leetcode;

public class rob198 {
    /**
     * Input: [1,2,3,1]
     * Output: 4
     * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
     *              Total amount you can rob = 1 + 3 = 4.
     * Example 2:
     * Input: [2,7,9,3,1]
     * Output: 12
     * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
     *              Total amount you can rob = 2 + 9 + 1 = 12.åInput: [1,2,3,1]
     * Output: 4
     * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
     *              Total amount you can rob = 1 + 3 = 4.
     * Example 2:
     * Input: [2,7,9,3,1]
     * Output: 12
     * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
     *              Total amount you can rob = 2 + 9 + 1 = 12.å
     * @param args
     */
    public static void main(String[] args) {
        int [] nums = {1,2,3,1,2,9};
        int rob = rob1(nums);
        System.out.println(rob);

    }
    public static int rob(int [] nums){

        return rob(nums,nums.length-1);
    }
    public static int rob1(int [] nums) {
        int []  dp = new int[nums.length+1];
        dp[1] = nums[0];
        for (int i = 1; i < nums.length; i++){
            dp[i+1] = Math.max(dp[i],dp[i-1]+ nums[i]);
        }
        return dp[nums.length];
    }

        private static int rob(int[] nums, int i) {
        if (i < 0){
            return 0;
        }
        return Math.max(rob(nums,i-2) + nums[i],rob(nums,i-1));
    }
}
