package company.practise18;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class jinritoutiao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int []group = new int[n+1];
        HashMap<Integer, List<Integer>> hashMap = new HashMap();
        for (int i = 1; i <= n; i++){
            group[i] = scanner.nextInt();
            LinkedList<Integer> list = new LinkedList<>();
            list.add(i);
            if (!hashMap.containsKey(group[i])) {
                hashMap.put(group[i], list);
            }else {
                List<Integer> list1 = hashMap.get(group[i]);
                list1.add(i);
            }
        }
        int m = scanner.nextInt();
        for (int i = 0; i < m ;i++){
            int count = 0;
            int left =0,right = 0,number =0;

                left = scanner.nextInt();
                right = scanner.nextInt();
                number = scanner.nextInt();
            List<Integer> integerList = hashMap.get(number);
            if (integerList != null){
                for (Integer num:integerList
                     ) {
                    if (num >= left && num <= right){
                        count++;
                    }
                }
                }
                System.out.println(count);
            }
    }
}
