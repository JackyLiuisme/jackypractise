package offer.allcharacter;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets.
 * Example:
 * Input: [1,2,2]
 * Output:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 */
public class subset2 {
    public static void main(String[] args) {
        int [] nums = {1,2,2};
        List<List<Integer>> list = subsets(nums);
    }
    public static List<List<Integer>> subsets(int [] nums) {
        List<Integer> list = new LinkedList<>();
        List<List<Integer>> lists = new LinkedList<>();
        backup(lists,list,0,nums);

        return lists;
    }
    public static void backup( List<List<Integer>> lists,List<Integer> list,int start,int []nums){

        lists.add(new LinkedList<>(list));
        for (int i = start; i < nums.length; i++){
            if ( i > start && nums[i] == nums[i-1]){
                continue;
            }
            list.add(nums[i]);
            backup(lists,list,i+1,nums);
            list.remove(list.size()-1);
        }
    }
}
