package leetcode;

public class maxArea {
    public int maxArea(int [] height){
        int left = 0,right= height.length-1;
        int max = 0;
        while (left < right){
            max = Math.max(right - left*Math.min(height[right],height[left]),max);
            if (height[left] > height[right]){
                right--;
            }else {
                left++;
            }
        }
        return max;
    }
}
