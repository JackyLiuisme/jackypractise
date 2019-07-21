package leetcode;

public class canJump55 {
    public static void main(String[] args) {
        int [] array = {2,3,1,1,4};
        boolean b = canJump(array);
        System.out.println(b);
    }
    public static boolean canJump(int [] nums){
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}

