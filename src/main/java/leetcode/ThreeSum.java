package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数组中的三个数相加等于0的所有数组成的数组
 */
public class ThreeSum {
    public static void main(String[] args) {
        int [] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> lists = threeSum(nums);
        for (List<Integer> list : lists
            ) {
            for (Integer n: list
                 ) {
                System.out.println(n);
            }
        }
    }
    public static List<List<Integer>> threeSum(int [] nums){
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i+2 < nums.length; i++){
            if (i > 0 && nums[i-1] == nums[i]){
                continue;
            }
            int left = i+1;
            int right = nums.length - 1;
            int target = -nums[i];
            while (left < right){
                if (target == nums[left] + nums[right]){
                    lists.add(Arrays.asList(-target,nums[left],nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left-1]){
                        left++;
                    }
                    while (left < right && nums[right+1] == nums[right]){
                        right-- ;
                    }
                }else if (target < nums[left] + nums[right]){
                    right--;
                }else {
                    left++;
                }
            }
        }
        return lists;
    }
}
