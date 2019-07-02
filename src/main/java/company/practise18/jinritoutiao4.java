package company.practise18;

import java.util.Scanner;

public class jinritoutiao4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.nextLine();

        for (int i = 0; i < n; i++){
            String string = scanner.nextLine();
            String result = removeRepluic(string);
            result = getResult(result);
            System.out.println(result);
        }
    }
    public static String removeRepluic(String string){
        if (string.length() ==1 || string.length() == 2 || string.length() == 0){
            return string;
        }
        char[] chars = string.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(chars[0]);
        for (int i = 1; i < chars.length; i++){
            if (i+1 < chars.length &&chars[i] == chars[i-1] && chars[i] == chars[i+1]){
                i++;
                while (i+1 < chars.length &&chars[i] == chars[i-1] && chars[i] == chars[i+1]){
                    i++;
                }
            }
            stringBuilder.append(chars[i]);
        }
        return stringBuilder.toString();
    }
    public static String  getResult(String string){

        if (string.length() ==1 || string.length() == 2 || string.length() == 0){
            return string;
        }
        char[] chars = string.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        char temp = chars[0];
        stringBuilder.append(temp);
        for (int i = 1; i < chars.length; i++){
            if (chars[i] != chars[i-1]){
                stringBuilder.append(chars[i]);
            }else if(i + 1 < chars.length && chars[i] == chars[i+1]){
                stringBuilder.append(chars[i]);
                i +=1;
                while (i+1 < chars.length &&chars[i] == chars[i+1]){
                    i++;
                }
            }else if(i + 2 < chars.length && chars[i+1] == chars[i+2]){
                stringBuilder.append(chars[i]);
                stringBuilder.append(chars[i+1]);
                i += 2;
            }else {
                stringBuilder.append(chars[i]);
            }
        }
        return stringBuilder.toString();
    }


}
