package offer;

import java.util.ArrayList;

public class GetLeastNumbers_Solution {
    public static void main(String[] args) {
        int []array = {4,5,1,6,2,7,3,8};
        ArrayList<Integer> list = GetLeastNumbers_Solution(array, 4);
    }
    static ArrayList<Integer> GetLeastNumbers_Solution(int [] array, int num){
        partitionSort(array,0,array.length-1,num);
        ArrayList<Integer>list = new ArrayList<>();
        for (Integer n:array
             ) {
            list.add(n);
            System.out.println(n);
        }
        return list;
    }
    public static void partitionSort(int[] nums, int low, int high, int K) {
        if (low < high) {
            int pointKey = partitionSortCore(nums, low, high);
            if (K - 1 == pointKey) {//TopK问题的核心，就是如果返回的下标为K-1，
                // 说明已经排序好了K个最大/最小的数，但是之间的顺序是不确定的
                return;
            }else if (pointKey < K -1) {
                partitionSort(nums, pointKey + 1, high, K);

            }else {
                partitionSort(nums, low, pointKey - 1, K);
            }
        }
    }

    /**
     * 快排的核心
     *
     * @param
     * @param low
     * @param high
     * @return 返回排序好以后的位置
     */
    public static int partitionSortCore(int[] a, int low, int high) {
        // 以第一个座位标志位来比对
        int k = a[low];
        while (low < high){
            while (low < high && a[high] > k){
                high--;
            }
            a[low] = a[high];
            while (low < high && a[low] < k){
                low++;
            }
            a[high] = a[low];
        }
        a[low] = k;
        return low;

      /*  while(low < high){
            while(low < high && a[high] > k) {
                --high;
            }

            a[low] = a[high];

            while(low < high && a[low] < k) {
                ++low;
            }

            a[high] = a[low];
        }
        a[low] = k;
        return low;*/
    }
}
