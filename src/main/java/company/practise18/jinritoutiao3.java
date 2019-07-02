package company.practise18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class jinritoutiao3 {
    static int dp[][] = new int[1005][1005];
    char str[] = new char[2005];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        char[] str = string.toCharArray();
        int n = scanner.nextInt();
        int max = 1;
        for (int ch = 0; ch < 26; ch++){
            int size = 0;
            ArrayList<Integer> v = new ArrayList<>();
            Arrays.fill(dp,63);
            for (int i = 0; i < str.length; i++){
                if (str[i] == (ch + 'a')){
                    v.add(i);
                    size++;
                    dp[size][size] = 0;
                }
            }

            for (int i = size-1; i >= 0; i--){
                for (int j = i+1; j < size; j++){
                    int dis = v.get(j) - v.get(i) - (j-i);
                    if (i+1 != j){
                        dis += dp[i+1][j-1];
                    }
                    dp[i][j] = Math.min(dp[i][j],dis);
                    if (dp[i][j] <= n){
                        max = Math.max(max,j-i+1);
                    }
                }
            }
        }
        System.out.println(max);
    }
}
