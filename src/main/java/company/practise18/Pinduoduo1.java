package company.practise18;

import java.util.Arrays;
import java.util.Scanner;

public class Pinduoduo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] num = new int[n];
        String temp = sc.nextLine();
        String string = sc.nextLine();
        String [] str = string.split("");
        for (int i = 0; i < n; i++){
            num[i] = Integer.valueOf(str[i]);
        }
        ysy(num,n,k);
    }
    static  public void ysy(int[] num,int n,int k) {
        st[] nx = new st[n];
        {
            for (int i = 0; i < n; i++){
                nx[i] = new st();
            }
        }
        st[] ny = new st[n];
        int cnt = Integer.MAX_VALUE, tmp;

        int []res = new int[n];

        for (int i = 9; i >= 0; --i) {

            for (int j = 0; j < n; ++j) {

                nx[j].setConsume(Math.abs(num[j] - i));

                nx[j].setNum( j);

                nx[j].setTarget( i);

                nx[j].setOri( num[j]);

            }
            Arrays.sort(nx, 0, n);

            tmp = 0;

            for (int p = 0; p < k; ++p) {

                tmp += nx[p].consume;

            }

            if (tmp <= cnt) {

                cnt = tmp;

                for (int j = 0; j < n; ++j) {
                    res[j] = num[j];
                }

                for (int p = 0; p < k; ++p) {
                    res[nx[p].num] = i;
                }

            }

        }

        System.out.println(cnt);
        for(int j=0;j<n;++j) {

            System.out.print(res[j]);
        }
    }
}
