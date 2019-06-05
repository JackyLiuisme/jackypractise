package offer;

import java.util.ArrayList;
import java.util.List;

public class subsets {
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        List<List<Integer>> lists = new ArrayList<>();
        Subset(list,nums,lists,0);
        return lists;
    }
    public void Subset(ArrayList<Integer> list,int[]nums,List<List<Integer>>lists,int k){
        lists.add(new ArrayList<>(list));
        for (int i = k; i < nums.length; i++){
            list.add(nums[i]);
            Subset(list,nums,lists,i+1);
            list.remove(list.size()-1);
        }
    }
}
