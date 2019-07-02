package company.practise18;

import java.util.Scanner;

public class Pinduoduo2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] array = new int[n+1];
        int sum=0 , max=0 ,i;
        for ( i = 1; i <= n; i++ ){
            int temp = scanner.nextInt();
            array[i] = temp;
            sum += temp;
            max = Math.max(max,temp);
        }
        if (max - (sum - max) > 1){
            System.out.println("-");
        }else {
            int temp = 0;
            while (sum > 0){
                int c = 0;

                for (int j = 1; j <= n; j++){
                    while (array[j] == 0 && j + 1 <= n){
                        j++;
                    }
                    if (j + 1 <= n && j == temp){
                        c++;
                        j++;
                    }else if (j + 1 > n){
                        break;
                    }
                    if (array[j] != 0) {

                        System.out.print(j + " ");
                        array[j]--;
                        temp = j;
                        c++;
                        sum--;
                        if (c == 2) {
                            break;
                        }
                    }
                }
            }
        }

    }
}
