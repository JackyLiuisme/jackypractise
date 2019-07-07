package company.practise18;

import java.util.LinkedList;
import java.util.Scanner;
/**
 * <a href=https://interview.nowcoder.com/questionTerminal/43068a1013b4417a85c2c2ce8b18159e>牛客描述</a>
 * 思路：分配后的房间里，人数最少的那一个房间就是i号房间。如果有多个房间人数最少，则取x号房间往前数的第一个人最少的房间。综上：无论哪种情况，从x房间往前数找到的第一个人最少的房间就是i号房间。
 * 找出i号房间后，就很容易求出之前的人数了。首先根据i号房间最后的人数确定完整的轮数，然后从x号往前再减去最后不足一轮的部分，然后把多出的人数全部补到第i个房间，就结束了
 * @author LBW
 */
public class jinritoutiaoc3 {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList[] = new LinkedList[10];
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt() - 1;
        long[] room = new long[n];
        long min = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            room[i] = scanner.nextInt();
            if (room[i] < min)
                min = room[i];
        }
        //get min_index
        int minIndex = x;
        while (room[minIndex] != min) {
            minIndex = minIndex > 0 ? minIndex - 1 : n - 1;
        }
        // remove the round number.
        for (int i = 0; i < n; i++) {
            room[i] -= min;
        }
        // remove the tail
        int remain = 0;
        for (int i = x; i != minIndex; i = i > 0 ? i - 1 : n - 1) {
            room[i] -= 1;
            remain += 1;
        }
        room[minIndex] += remain + n * min;
        //print the result
        for (int i = 0; i < n; i++) {
            System.out.print(room[i] + " ");
        }
    }
}
