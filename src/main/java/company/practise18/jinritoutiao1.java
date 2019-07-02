package company.practise18;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class jinritoutiao1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        int m = scanner.nextInt();
        int c = scanner.nextInt();
        int count = 0;
        boolean[] flag = new boolean[c+1];
        for (int i = 1; i <= n; i++){
            int length = scanner.nextInt();


            for (int j = 0; j < length; j++){
                int color = scanner.nextInt();
                if (!hashMap.containsKey(color)) {
                    LinkedList<Integer> list = new LinkedList<>();
                    list.add(i);
                    hashMap.put(color, list);
                }else {
                    List<Integer> list1 = hashMap.get(color);
                    Integer integer = list1.get(list1.size() - 1);
                    if ((i - integer < m || i - n + m-1 > 0) && !flag[color]){
                        count++;
                        flag[color] = true;
                    }
                    list1.add(i);
                }
            }
        }
        System.out.println(count);
    }
}
