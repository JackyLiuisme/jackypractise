package offer.allcharacter;

import java.util.*;

/**
 * Each number in candidates may only be used once in the combination.
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 *
 * Example 2:
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 *   [1,2,2],
 *   [5]
 * ]]
 */
public class subResult2 {
    public static void main(String[] args) {
        int [] nums = {1,2,5,2,2};
        combinationSum(nums,5);
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backUp(lists,list,candidates,target,0);
        HashSet<List<Integer>>hashSet = new HashSet<>();
        Iterator<List<Integer>> iterator = lists.iterator();
        while (iterator.hasNext()){
            List<Integer> next = iterator.next();
            hashSet.add(next);
        }
        List<List<Integer>> result = new LinkedList<>();
        Iterator<List<Integer>> iterator1 = hashSet.iterator();
        while (iterator1.hasNext()){
            result.add(iterator1.next());
        }
        return result;
    }

    private static void backUp(List<List<Integer>> lists, List<Integer> list, int[] candidates, int target, int start) {
        if (target < 0){

            return;
        }else if (target == 0){
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++){
            list.add(candidates[i]);
            backUp(lists,list,candidates,target-candidates[i],i+1);
            list.remove(list.size()-1);
        }
    }

}
