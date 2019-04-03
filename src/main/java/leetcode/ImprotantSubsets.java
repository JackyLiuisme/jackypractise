package leetcode;

import java.util.*;

/**
 * 找所有的字符子串
 */
public class ImprotantSubsets {

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        Random random = new Random();
        System.out.println(random.nextInt());


       List<List<Integer>> subsets = subsets1(nums);
        for (List<Integer> list :
                subsets) {
            System.out.println(list.size());
        }
    }

    public static List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> lists = new LinkedList<>();

        List<Integer> temp = new ArrayList<>();
       /* for (int n: nums
        ) {
            temp.add(n);
        }*/
        HashSet<List<Integer>> hashSet = new HashSet<>();
        sort(hashSet,temp,nums,0);
        lists.addAll(hashSet);
        return lists;
    }

    public static void sort(HashSet<List<Integer>> hashSet,List<Integer> list,int[]nums,int  k){
        if (list.size() == nums.length){
            hashSet.add(new ArrayList<>(list));
        }
        for (int i = k; i < nums.length; i++){
            swap(nums,i,k);
            sort(hashSet,list,nums,i+1);
            swap(nums,i,k);
        }
    }
    public static void swap(int []nums,int left,int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }



    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
