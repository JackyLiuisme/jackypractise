package leetcode.dynamicprograming;

import java.util.Arrays;
import java.util.Comparator;

public class findLongestChain {
    public static void main(String[] args) {
        int [][] array = {{1,2},{4,5},{2,4}};
        int longestChain = findLongestChain(array);
        System.out.println(longestChain);
    }
    public static int findLongestChain(int [][] pairs){
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int i = -1,n = pairs.length,count = 0;
        while (++i < n ){
            int temp = pairs[i][1];
            count++;
            while (i + 1 < n && temp >= pairs[i+1][0]){
                i++;
            }
        }
        return count;
    }
}
