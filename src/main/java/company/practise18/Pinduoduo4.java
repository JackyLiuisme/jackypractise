package company.practise18;

import java.util.Scanner;

public class Pinduoduo4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int result = 0;
        int num = scanner.nextInt();
        int normalAttack = scanner.nextInt();
        int buffedAttack = scanner.nextInt();
        if (buffedAttack <= normalAttack * 2){
            result = num / normalAttack;
            if (num % normalAttack != 0){
                result++;
            }
        }else {
            if (num <= normalAttack * 2){
                result  = num / normalAttack;
                if (num % normalAttack != 0){
                    result++;
                }
            }else {
                result = num / buffedAttack * 2;
                if (num % buffedAttack <= normalAttack){
                    result++;
                }else {
                    result += 2;
                }
            }
        }
        System.out.println(result);
    }
}
