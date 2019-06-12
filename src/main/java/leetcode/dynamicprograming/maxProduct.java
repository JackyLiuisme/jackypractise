package leetcode.dynamicprograming;

/**
 * 求连续子串的最大乘积
 */
public class maxProduct {
    public int maxProduct(int []nums){
        int maxNow = nums[0],minNow = nums[0],result = nums[0];
       for (int i = 1; i < nums.length; i++){
           int temp = maxNow;
           maxNow = Math.max(Math.max(maxNow*nums[i],minNow*nums[i]),nums[i]);
           minNow = Math.min(Math.min(temp*nums[i],minNow*nums[i]),nums[i]);
           result = Math.max(result,maxNow);
       }
       return result;
    }
}
