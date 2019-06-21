package company.practise18;

import java.util.Scanner;

public class main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int first = 1, second = 1, third = 1,min1 = 1,min2 = 1;
        while (scanner.hasNext()){
            int temp = scanner.nextInt();
            if (temp > 0) {
                if (temp > first) {

                    third = second;
                    second = first;
                    first = temp;

                } else if (temp > second) {
                    third = second;
                    second = temp;

                } else if (temp > third) {
                    third = temp;
                }
            }else {
                if ( temp < min1) {
                    min2 = min1;
                    min1 = temp;
                } else if (temp < 0 && temp < min2) {
                    min2 = temp;
                }
            }
        }
        int result = first*second*third > min1*min2*first ? first*second*third:min1*min2*first;

    }
}
