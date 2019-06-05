package offer;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class permute {
    public static void main(String[] args) {
        permute permute = new permute();
        int [] nums = {1,2,3};
        List<List<Integer>> permute1 = permute.permute(nums);

    }
    public List<List<Integer>> permute(int[] nums) {
        HashSet<List<Integer>> hashSet = new HashSet<>();
        List<List<Integer>> lists = new LinkedList<>();
        Sort(hashSet,nums,0);
        lists.addAll(hashSet);
        return lists;
     }
     public void Sort(HashSet<List<Integer>> hashSet, int[]nums,int k){
        if (k == nums.length-1){
            List<Integer> list = new LinkedList<>();
            for (int i :nums
                 ) {
                list.add(i);
            }
            hashSet.add(list);
        }
        for (int i = k; i < nums.length; i++){
            swap(nums,i,k);
            Sort(hashSet,nums,k+1);
            swap(nums,i,k);
        }
     }

     public void swap(int []nums,int left,int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
     }
}
