package company.practise18;

import java.util.Scanner;

public class Pinduoduo2 {

    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);

        int N=input.nextInt();

        int[] nums=new int[N];

        int M=0;
        int max = -1;
        for(int i = 0; i <N ; i++) {

            nums[i]=input.nextInt();

            M+=nums[i];
            if (nums[i] > max){
                max = nums[i];
            }
        }

        if (max > (M - max)){
            System.out.println("-");
            return;
        }

        StringBuffer res=new StringBuffer();

        int count=M;

        int pre=-1;

        for(int i=0;i<M;i++){

            boolean flag=false;

            for(int k=0;k<N;k++){

                if(nums[k]>count/2){   //判断是否有树大于剩余的一半

                    res.append(k+1);

                    res.append(" ");

                    nums[k]--;

                    pre=k+1;

                    flag=true;

                    count--;

                    break;

                }

            }

            if(flag==true) continue;

            int j=0;

            while((j < N) &&(nums[j]==0||(j+1)==pre)){

                j++;

            }

            nums[j]--;

            pre=j+1;

            res.append(j+1);

            res.append(" ");

            count--;

        }

        System.out.println(res.toString().trim());

    }


}
