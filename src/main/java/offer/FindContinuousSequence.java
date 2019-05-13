package offer;

import java.util.ArrayList;

public class FindContinuousSequence {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> lists = FindContinuousSequence(100);
        for (ArrayList<Integer> list:lists
             ) {
            for (int i : list
                 ) {
                System.out.println(i);
            }
        }
    }
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        int left = 1, right = 2;
        while (left < right){
           int temp = 0;
           temp = (left + right) * (right - left + 1) / 2;
            if (temp == sum){
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = left; i <= right; i++){
                    list.add(i);
                }
                lists.add(list);
                left++;
            }else if (temp < sum){
                right++;
            }else {
                left++;
            }
        }
        return lists;
    }
}
