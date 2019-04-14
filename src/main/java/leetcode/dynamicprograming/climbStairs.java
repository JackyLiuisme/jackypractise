package leetcode.dynamicprograming;

public class climbStairs {
    public static void main(String[] args) {
        int i = climbStairs(3);
    }

    public static int climbStairs(int n) {
        if (n == 1){
            return 1;
        }if (n== 2){
            return 2;
        }
        int result = 1,a = 1,b = 2;
        while (n > 2){
               result = a + b;
               a = b;
               b = result;
               n--;
        }
        return result;
    }
}
