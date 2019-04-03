package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *22. Generate Parentheses
 * Medium
 *
 * 2507
 *
 * 152
 *
 * Favorite
 *
 * Share
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 *
 */
public class generateParenthesis {
    public static void main(String[] args) {
        List<String> strings = generateParenthesis1(3);
        for (String s:strings
             ) {
            System.out.println(s);
        }
    }
    public static List<String> generateParenthesis1(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    public static void backtrack(List<String> list, String str, int open, int close, int max){

        if(str.length() == max*2){
            list.add(str);
            return;
        }

        if(open < max) {
            backtrack(list, str + "(", open + 1, close, max);
        }
        if(close < open) {
            backtrack(list, str + ")", open, close + 1, max);
        }
    }
}
