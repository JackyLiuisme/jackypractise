package company.practise18;

import java.util.ArrayList;
import java.util.Scanner;

public class pdd2 {

    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        int n =sc.nextInt();
        class point{
            int x;
            int y;
            point(int m1,int m2){
                x=m1;
                y=m2;
            }

        }

        ArrayList<point> l1 =new ArrayList<>();
        for(int i =0;i<n;i++){
            l1.add(new point(sc.nextInt(),sc.nextInt()));
        }
        int count =0;

        for(int i =0 ;i<l1.size();i++){
            for(int j =i+1;j<l1.size();j++){
                for(int k = j+1;k<l1.size();k++){
                    int a =(l1.get(i).x-l1.get(j).x)*(l1.get(i).y-l1.get(k).y);
                    int b =(l1.get(i).y - l1.get(j).y)*(l1.get(i).x-l1.get(k).x);
                    if(a != b){
                        count++;
                    }

                }
            }
        }

        System.out.println(count);



    }
}
