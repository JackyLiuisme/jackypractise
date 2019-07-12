package offer.allcharacter;

import java.util.*;

/**
 * Input: [1,1,2]
 * Output:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 */
public class sublist2 {
    public static void main(String[] args) {
        int [] nums = {1,2,2};
        sublists(nums);
    }

    public static List<List<Integer>> sublists(int [] nums) {

        HashSet<List<Integer>> hashSet = new HashSet<>();
        backup(hashSet,nums,0);
        List<List<Integer>> listList = new LinkedList<>();
        Iterator<List<Integer>> iterator = hashSet.iterator();
        while (iterator.hasNext()){
            List<Integer> next = iterator.next();
            listList.add(next);
        }
        return listList;
    }


    public static void backup( HashSet<List<Integer>> lists ,int []nums,int start){
        if (start == nums.length -1){
            List<Integer> list = new LinkedList<>();
            for (int i:nums
                 ) {
                list.add(i);
            }
            lists.add(new LinkedList(list));
        }

        for (int i = start; i < nums.length; i++){
           swap(start,i,nums);
           backup(lists,nums,start+1);
           swap(i,start,nums);
        }
    }

    private static void swap(int left,int right,int []nums) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
