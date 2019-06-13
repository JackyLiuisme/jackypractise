package leetcode.dynamicprograming;

public class lengthOfList {
    public static void main(String[] args) {
        int [] array = {10,9,2,5,3,7,101,10};
        int i = lengthoFlIS(array);
        System.out.println(i);
    }
    public static int lengthoFlIS(int [ ] nums){
        int[] dp = new int[nums.length];
      for (int i= 0; i < nums.length; i++){
          dp[i] = 1;
          for (int j = 0; j < i; j++){
              if (nums[j] < nums[i]){
                  dp[i] = Math.max(dp[j]+1,dp[i]);
              }
          }
      }
        return dp[dp.length-1];
    }
}
