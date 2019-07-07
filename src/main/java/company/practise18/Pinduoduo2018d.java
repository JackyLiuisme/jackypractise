package company.practise18;

import java.util.Scanner;

public class Pinduoduo2018d {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long first =0,second=  0,third=0;
        long min1=0,min2=0;
        if (n < 3){
            return;
        }
        for (int i = 0; i < n; i++){
            long temp = scanner.nextLong();
            if (temp > 0){
                if (temp > first){
                    third = second;
                    second = first;
                    first = temp;
                }else if (temp > second){
                    third = second;
                    second = temp;
                }else if (temp > third){
                    third = temp;
                }
            }else {
                if (temp < min1){
                    min2 = min1;
                    min1 = temp;
                }else if (temp < min2){
                    min2 = temp;
                }
            }

        }
        long right = first*second*third;
        long left = first*min1*min2;
        if (right > left){
            System.out.println(right);
        }else {
            System.out.println(left);
        }
    }
}
