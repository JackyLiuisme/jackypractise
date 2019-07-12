package offer.allcharacter;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * Example:
 * Input: "aab"
 * Output:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 */
public class subPalidrom {
    public static void main(String[] args) {
        String string = "aab";
        partion(string);
    }
    public static List<List<String>> partion(String s){
        List<List<String>> lists = new ArrayList<>();
        List<String> list = new ArrayList<>();
        backUp(lists,list,s,0);
        return lists;
    }

    private static void backUp(List<List<String>> lists, List<String> list, String s, int start) {
        if (start == s.length()){
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = start;  i < s.length(); i++){
            String temp = s.substring(start,i+1);
            if (isPalimdro(temp)){
                list.add(temp);
                backUp(lists,list,s,i+1);
                list.remove(list.size()-1);
            }
        }
    }

    private static boolean isPalimdro(String substring) {
        int left = 0,right = substring.length()-1;
        char[] chars = substring.toCharArray();
        while (left < right){
            if (chars[left] != chars[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
