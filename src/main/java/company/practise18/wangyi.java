package company.practise18;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class wangyi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        HashMap<Integer,Integer> map = new HashMap();
        int [] sort = new int[n+m];
        int [] result = new int[m];
         for (int i = 0; i < n; i++){
             sort[i] = scanner.nextInt();
            int temp = scanner.nextInt();
            map.put(sort[i],temp);
        }
         for (int i = 0; i < m; i++){
             int temp = scanner.nextInt();
             sort[i+n] = temp;
             result[i] = temp;
             if (!map.containsKey(temp)){
                 map.put(temp,0);
             }
         }
        Arrays.sort(sort);
         int max = 0;
         for (int i = 0; i < n+m; i++){
             max = Math.max(max,map.get(sort[i]));
             map.put(sort[i],max);
         }
         for (int i = 0; i < m; i++){
             System.out.println(map.get(result[i]));
         }
    }
}
