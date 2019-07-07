package company.practise18;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 * 输入描述:
 * 第一行输入n，m，c三个数，用空格隔开。(1 <= n <= 10000, 1 <= m <= 1000, 1 <= c <= 50) 接下来n行每行的第一个数num_i(0 <= num_i <= c)表示第i颗珠子有多少种颜色。接下来依次读入num_i个数字，每个数字x表示第i颗柱子上包含第x种颜色(1 <= x <= c)
 *
 * 输出描述:
 * 一个非负整数，表示该手链上有多少种颜色不符需求。
 *
 * 输入例子1:
 * 5 2 3
 * 3 1 2 3
 * 0
 * 2 2 3
 * 1 2
 * 1 3
 *
 * 输出例子1:
 */
public class jinritoutiaoB {
    public static void main(String[] args) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int c = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            int temp = scanner.nextInt();
            for (int j = 0; j < temp; j++){
                int num = scanner.nextInt();
                if (!map.containsKey(num)){
                    ArrayList<Integer> list =new ArrayList();
                    list.add(i);
                    map.put(num,list);
                }else {
                    ArrayList<Integer> list = map.get(num);
                    list.add(i);
                }
            }
        }
        int count = 0;
        for (int i = 1; i <= c; i++){
            ArrayList<Integer> list = map.get(i);
            Iterator<Integer> iterator = list.iterator();
            Integer num1 = iterator.next();
            Integer min = num1;
            while (iterator.hasNext()){
                Integer next = iterator.next();
                if (Math.abs(next - num1) < m || (n - next + 1) < m){
                    count++;
                    break;
                }
                num1 = next;
            }
        }
        System.out.println(count);
    }

}
