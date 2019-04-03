package company.practise18;

import java.util.Scanner;

public class main6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // x:每天的房租  f: 水果的个数  d: 已经有的钱  p：每个水果的单价
        // max * x + max * p <= d  85 / (3 + 10) + 5
        String string = scanner.nextLine();
        String[] s = string.split(" ");
        String num1 = s[0];
        String num2 = s[1];
        StringBuilder stringBuilder = new StringBuilder(num1);
       num1 = stringBuilder.reverse().toString();
       StringBuilder stringBuilder1 = new StringBuilder(num2);
       num2 = stringBuilder1.reverse().toString();
        int [] sum = new int[num1.length()+num2.length()];
        for (int i = 0; i < num1.length(); i++){
            for (int j = 0; j < num2.length(); j++){
                sum[i+j] += (num1.charAt(i) - '0' ) * (num2.charAt(j) -'0' );
            }
        }
        for (int i = 0; i < sum.length; i++){
            int carry = 0;
            if (sum[i] > 10){
                carry = sum[i] / 10;
                sum[i] = sum[i] % 10;
            }
            if (i < sum.length -1)
            sum[i+1] += carry;
        }
        int count = 0;
        for (int i = sum.length - 1; i >0 ; i--){
            if (sum[i] != 0 ){

                break;
            }
            count++;
        }
        for (int i = sum.length - count -1; i >= 0; i--){
            System.out.println(sum[i]);
        }
    }
}
