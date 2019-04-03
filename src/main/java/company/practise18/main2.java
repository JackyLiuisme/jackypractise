package company.practise18;

import java.util.Scanner;

public class main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String next = scanner.nextLine();
            System.out.println(next);
        }
        /*String s = scanner.nextLine();
        char[] chars = s.toCharArray();
        int max = 0,i,j;
        for (i = 0; i < chars.length; ){
            int count = 0;
            for ( j = i+1; j < chars.length; j++){

                if (chars[j] != chars[j-1]){
                    count++;
                }else {
                    break;

                }
            }
            i = j;
            if (max < count){
                max = count;
            }
        }
        System.out.println(max);*/
    }
}
