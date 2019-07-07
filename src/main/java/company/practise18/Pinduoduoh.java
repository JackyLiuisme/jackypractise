package company.practise18;

import java.util.Arrays;
import java.util.Scanner;

public class Pinduoduoh {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int []h = new int[n];

        for (int i= 0; i < n;i++ ){
            h[i] = scanner.nextInt();
        }
        Arrays.sort(h);
        int m = scanner.nextInt();
        int []w = new int[m];
        for (int i = 0; i < m; i++){
            w[i] = scanner.nextInt();
        }
        int count = 0;
        Arrays.sort(w);

            for (int j = m-1, i = n-1; j >= 0 && i >= 0; i--){
                if (w[j] >= h[i]){
                    count++;
                    j--;

                }
            }

        System.out.println(count);
    }
}
