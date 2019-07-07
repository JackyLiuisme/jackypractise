package company.practise18;

import java.util.*;

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
                nx[i] =new  Pinduoduo1.st();
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
            /**
             *  public int compareTo(st o) {
             *         if (this.consume != o.consume){
             *             return this.consume - o.consume;
             *         }
             *         if (this.num < o.num){
             *             return this.num - o.num;
             *         }
             *
             *         return   o.ori - o.target;
             *     }
             */
            Arrays.sort(nx, 0, n, new Comparator<st>() {
                @Override
                public int compare(st o1, st o2) {
                    if (o1.consume != o2.consume){
                        return o1.consume - o2.consume;
                    }
                    if (o1.num < o2.num){
                        return o1.num - o2.num;
                    }
                    return o1.ori - o2.target;
                }
            });

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
    public static class st{
        public int consume,num,target,ori;
        public int getConsume() {
            return consume;
        }

        public void setConsume(int consume) {
            this.consume = consume;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public void setTarget(int target) {
            this.target = target;
        }

        public void setOri(int ori) {
            this.ori = ori;
        }

        public int getNum() {
            return num;
        }

        public int getTarget() {
            return target;
        }

        public int getOri() {
            return ori;
        }
    }
}
