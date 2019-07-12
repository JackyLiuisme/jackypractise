package offer;

public class FindGreatestSumOfSubArray {
    public static void main(String[] args) {
        int [] array = {6,-3,-2,7,-15,1,2,2};
        int i = FindGreatestSumOfSubArray(array);
        System.out.println(i);
    }
    public static int FindGreatestSumOfSubArray(int[] array) {
       int [] dp = new int[array.length];
       int result = 0,temp = 0;
       dp[0] = array[0];
       for (int i = 1; i < array.length; i++){
           dp[i] = Math.max(array[i],dp[i-1] + array[i]);
           result = Math.max(result,dp[i]);
       }
       return result;
    }
}
