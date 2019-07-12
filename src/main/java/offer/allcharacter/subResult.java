package offer.allcharacter;

import java.util.ArrayList;
import java.util.List;

/**
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 *
 * Example 2:
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */
public class subResult {
    public static void main(String[] args) {
        int [] nums = {1,2,3};
        combinationSum(nums,6);
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> lists = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            backUp(lists,list,candidates,target,0);
            return lists;
    }

    private static void backUp(List<List<Integer>> lists, List<Integer> list, int[] candidates, int target, int start) {
        if (target < 0){
            lists.add(new ArrayList<>(list));
            return;
        }else if (target == 0){
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++){
            list.add(candidates[i]);
            backUp(lists,list,candidates,target-candidates[i],i);
            list.remove(list.size()-1);
        }
    }

}
