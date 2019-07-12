package offer.allcharacter;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given a collection of distinct integers, return all possible permutations.
 * Example:
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class sublist1 {
    public static void main(String[] args) {
        int [] nums = {1,2,3};
        sublists(nums);
    }

    public static List<List<Integer>> sublists(int [] nums) {
        List<List<Integer>> lists = new ArrayList<>();

        backUp(lists,nums,0);
        return lists;
    }

    private static void backUp(List<List<Integer>> lists, int[] nums, int start) {
        if (start == nums.length - 1){
            List<Integer> list = new ArrayList<>();
            for (int n:nums
                 ) {
                list.add(n);
            }
            lists.add(list);
        }
        for (int i = start; i < nums.length; i++){
                swap(nums,i,start);
                backUp(lists,nums,start+1);
                swap(nums,start,i);
        }
    }

    private static void swap(int[] nums, int i, int start) {
        int temp = nums[i];
        nums[i] = nums[start];
        nums[start] = temp;
    }

        /*      List<Integer> list = new LinkedList<>();
        List<List<Integer>> lists = new LinkedList<>();
        backup(lists,list,nums);
        return lists;
    }
    
    
    public static void backup( List<List<Integer>> lists,List<Integer> list,int []nums){
        if (list.size() == nums.length){
            lists.add(new LinkedList<>(list));
        }

        for (int i = 0; i < nums.length; i++){
            if (list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            backup(lists,list,nums);
            list.remove(list.size()-1);
        }
    }*/
}
