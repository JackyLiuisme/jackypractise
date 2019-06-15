package leetcode;

/**
 * PAHNAPLSIIGYIR字符串以某个数字进行z字折断，然后再进行重新读取
 */
public class ConvertZigZag {
    public static String convert(String s, int numRows){
        int size = 2*numRows - 2;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numRows; i++){
            for (int j = i ; j < s.length(); j++){
                stringBuilder.append(s.charAt(j));
                if (i != 0 && i != numRows-1){
                    int k = j + size - 2*i;
                    if (k < s.length()) {
                        stringBuilder.append(s.charAt(k));
                    }
                }
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String pahnaplsiigyir = convert("PAHNAPLSIIGYIR", 3);
        System.out.println(pahnaplsiigyir);
    }
}
