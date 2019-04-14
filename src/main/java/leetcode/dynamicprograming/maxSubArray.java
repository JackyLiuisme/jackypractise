package leetcode.dynamicprograming;


/**
 *
 * int sum = 0,max =0;
 *         for (int i = 0; i < nums.length; i++){
 *             sum += nums[i];
 *             if (sum  < 0){
 *                     sum = 0;
 *             }
 *             max = Math.max(sum,max);
 *         }
 *         return max;
 */
public class maxSubArray {

    public static void main(String[] args) {
        int [] array = {-2,1,-3,4,-1,2,1,-5,4};
        maxSubArray(array);
    }
    public static int maxSubArray(int[] nums) {
        int [] temp = new int[nums.length];
        temp[0] = nums[0];
        int max =temp[0];
        for (int i = 1; i < nums.length; i++){
           temp[i] = nums[i] + (temp[i-1] > 0 ? temp[i-1]:0);
           max = Math.max(max,temp[i]);
        }
        return max;
    }
}
