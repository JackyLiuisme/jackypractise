package company.practise18;

import java.util.Scanner;

public class main5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       String num =   scanner.nextLine();
        String s = scanner.nextLine();
        Integer n = Integer.valueOf(num);
        String[] str = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++){
               stringBuilder.append(str[i]);
               stringBuilder.reverse();
        }
        for (int i = 0 ; i < n ; i++) {
            char c = stringBuilder.charAt(i);
            if (i < n -1)
            System.out.println(c+" ");
            else {
                System.out.println(c);
            }
        }
    }
}
