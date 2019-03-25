package offer;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       // String str = scanner.next();
        while (scanner.hasNext()) {
            int tem = scanner.nextInt();
            System.out.println(tem);
        }
        String str = scanner.next();

        char[] chars = str.toCharArray();
        int length = chars.length,i = 0,sum =0;
        String temp = "";

        while (i < length && chars[i] !='+'  && chars[i] !='-'  ){
             temp += String.valueOf(chars[i]);
             i++;
        }
        sum = Integer.valueOf(temp);
       while (length > i){

           boolean flag = true;
           if (chars[i] =='-' ){
               flag = false;
           }
            i++;
           String temp1 = "";
           while (i < length&&chars[i] !='+'  && chars[i] !='-'  ){
               temp1 += String.valueOf(chars[i]);
               i++;
           }

           if (flag){
               sum = sum + Integer.valueOf(temp1);


           }else {
               sum = sum - Integer.valueOf(temp1);
           }

       }
    System.out.println(sum);
    }
}
