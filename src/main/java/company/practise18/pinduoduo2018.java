package company.practise18;

import java.util.Scanner;

public class pinduoduo2018 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int offset = scanner.nextInt();
        int next = scanner.nextInt();
        int L1 = scanner.nextInt();
        int L2 = scanner.nextInt();
        if (offset < L1){
            int temp = offset + next;
            if (temp <= L1){
                System.out.println(offset+" "+ temp+" " + "0 "+ "0");
            }else if(temp > L1 && temp <= L2+L1){
                System.out.println(offset+" "+ L1+" " + "0 "+ (temp-L1));
            }else {
                System.out.println(offset+" "+ L1+" " + "0 "+ L2);
            }
        }else if (offset >= L1 && offset <= L1+L2){
            int temp = offset + next;
            if (temp <= L2+L1){
                System.out.println(L1+" "+ L1+" " + (offset-L1)+" "+ (temp-L1));
            }else {
                System.out.println(L1+" "+ L1+" " + (offset-L1)+" "+ L2);
            }
        }else {
            System.out.println(L1+" "+ L1+" " + L2+" "+ L2);
        }
    }
}
