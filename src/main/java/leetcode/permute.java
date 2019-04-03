package leetcode;

import java.util.*;

public class permute {
    public static void main(String[] args) {
        int[] array = {1,2,3};
        List<List<Integer>> permute = permute(array);
        for (List list:permute){
            Iterator iterator = list.iterator();
            while (iterator.hasNext()){
                System.out.println(iterator.next());
            }
        }
    }
    public static List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> lists = new LinkedList<List<Integer>>();
        HashSet<List<Integer>> set = new HashSet<List<Integer>>();
        sort(set,nums,0);
        lists.addAll(set);
        return lists;
    }

    private static void sort(HashSet<List<Integer>> set,int [] nums,int k){
        if (k == nums.length-1){
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int i : nums){
                list.add(i);
            }
            set.add(list);
        }
        for (int i = k; i < nums.length; i++){
            swap(nums,i,k);
            sort(set,nums,k+1);
            swap(nums,i,k);
        }
    }
    private static void swap(int [] array,int left,int right){
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
