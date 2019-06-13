package leetcode.dynamicprograming;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出字符串的所有递归子串组成的数组
 * aab 得到 {{a,a,b}{aa,b}}
 */
public class Partition {
    public static void main(String[] args) {
        List<List<String>> aab = partion("aab");
        for (List<String> S:aab
             ) {
            for (String string:S
                 ) {
                System.out.println(string);
            }
        }
    }
     static  List<List<String>> lists = new ArrayList<>();

    public static List<List<String>> partion(String s) {
        List<String> list = new ArrayList<>();
        getNextWord(list,0,s);
        return lists;
    }

    public static  List<List<String>> getNextWord(List<String> list, int index, String s){

        if (index == s.length()){
            lists.add(new ArrayList<String>(list));
        }
        for (int i = index; i < s.length(); i++){
            String temp = s.substring(index,i+1);
            if (isRight(temp)){
            list.add(temp);
            getNextWord(list,i+1,s);
            list.remove(list.size()-1);
            }
        }
        return lists;
    }

    public static boolean isRight(String s){
        int left = 0,right = s.length()-1;
        for (int i = 0; i <= s.length()/2; i++){
            if (s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }















    /*public static List<List<String>> partion(String s){
        nextword(s,0,new ArrayList<>());
        return lists;
    }

    public static void nextword(String s,int index,List<String> list){
        if (index == s.length()){
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < s.length(); i++){
            String subStr = s.substring(index,i+1);
            if (isPalindrome(subStr)){
                list.add(subStr);
                nextword(s,i+1,list);
                list.remove(list.size()-1);
            }
        }
    }
    public static boolean isPalindrome(String s){
        for (int i = 0; i <= s.length()/2; i++){
            if (s.charAt(i) != s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }*/
}
