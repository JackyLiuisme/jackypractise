package leetcode;

/**
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 *
 * Example:
 *
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * Note: Please solve it without division and in O(n).
 *
 * Follow up:
 * Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
 *
 *
 */
public class productExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        productExceptSelf(nums);
    }
    public static int[] productExceptSelf(int[] nums) {
       // int[] output = new int[nums.length];
        int max = 1;
        for (int i = 0; i < nums.length; i++){
            max *= nums[i];
        }
        for (int i = 0; i < nums.length; i++){
            nums[i] =  max / nums[i];
        //    System.out.println(nums[i]);
        }
        return nums;
    }
}
