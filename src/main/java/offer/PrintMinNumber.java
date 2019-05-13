package offer;

import java.util.Arrays;
import java.util.Comparator;

public class PrintMinNumber {
    public String PrintMinNumber(int [] numbers){
        String s = String.valueOf(numbers);
        String [] str = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++){
            str[i]  = String.valueOf(numbers[i]);
        }
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s1.compareTo(s2);
            }
        });
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numbers.length; i++){
            stringBuilder.append(str[i]);
        }
        return stringBuilder.toString();
    }
}
