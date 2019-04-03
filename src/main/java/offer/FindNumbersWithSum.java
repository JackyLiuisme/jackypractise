package offer;

import java.util.ArrayList;

public class FindNumbersWithSum {
    public static void main(String[] args) {
        int[] array = {1,2,4,7,11,15};
        FindNumbersWithSum(array,15);
    }
   static public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int left = 0, right = array.length-1;
        while (left < right) {
            if (array[left] + array[right] == sum) {
                list.add(array[left]);
                list.add(array[right]);
                break;
            } else if (array[left] + array[right] > sum) {
                right--;
            } else {
                left++;
            }
        }
        return list;
    }
}

