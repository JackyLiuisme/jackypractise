package leetcode.dynamicprograming;

public class longestPalindrome {
    public static void main(String[] args) {
        String s = "babad";
        String s1 = longestPalindrome(s);
        System.out.println(s1);
    }
     static int start=0,count=0;
    public static String longestPalindrome(String s) {
            for (int i = 0; i < s.length(); i++){
                getPanlidrome(s,i,i);
                getPanlidrome(s,i,i+1);
            }
            return s.substring(start,start+count);
    }
    public static void getPanlidrome(String s ,int left, int right){
        while (left > 0. && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        if (right - left - 1 > count){
            start = left+1;
            count = right - left - 1;
        }
    }
}
