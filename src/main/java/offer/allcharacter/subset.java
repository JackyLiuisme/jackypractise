package offer.allcharacter;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets.
 * Example:
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class subset {
    public static void main(String[] args) {
        int [] nums = {1,2,3};
        subsets(nums);
    }
    public static List<List<Integer>> subsets(int [] nums){
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backUp(lists,list,nums,0);
        return lists;
    }

    private static void backUp(List<List<Integer>> lists, List<Integer> list, int[] nums, int start) {
        lists.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++){
            list.add(nums[i]);
            backUp(lists,list,nums,i+1);
            list.remove(list.size()-1);
        }
    }
   /* public static List<List<Integer>> subsets(int [] nums){
        List<List<Integer>> lists = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        backword( lists,list,nums,0);
        for (List<Integer> l:lists
             ) {
            for (Integer n:l
                 ) {
                System.out.println(n);
            }
        }
        return lists;
    }
    public static void backword(List<List<Integer>> lists,List<Integer> list,int [] nums,int start){
        lists.add(new LinkedList<>(list));
        for (int i = start; i < nums.length; i++){
            list.add(nums[i]);
            //重点在这里，传入的参数是 i+1而不是start + 1,因为传入了start的话，得到的结果就会重复；
            backword(lists,list,nums,i+1);
            list.remove(list.size()-1);
        }
    }*/

}
