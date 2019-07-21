package leetcode;

/**
 * 强盗只能间隔着偷东西
 */
public class houseRobber198 {
    public static void main(String[] args) {
        int [] nums = {1,1,2};
        int rob = removeDuplicates(nums);
        boolean palindrome = isPalindrome(",,A man,, a plan, a canal: Panama");
        System.out.println(palindrome);
    }

    public static boolean isPalindrome(String s) {
        char[] c = s.toCharArray();
        for (int i = 0, j = c.length - 1; i < j; ) {
            if (!Character.isLetterOrDigit(c[i])) i++;
            else if (!Character.isLetterOrDigit(c[j])) j--;
            else if (Character.toLowerCase(c[i++]) != Character.toLowerCase(c[j--]))
                return false;
        }
        return true;
    }

    public static int removeDuplicates(int[] nums) {
        int result = 1;
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int temp = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i-1]){
                continue;
            }
            result++;
        }
        return result;
    }
    public static int rob(int[] nums) {
        int [] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0],nums[1]);
        for (int i = 2; i < nums.length; i++){
            dp[i] = Math.max(dp[i-2] + nums[i],dp[i-1] );
        }
        return dp[nums.length-1];
    }
}
