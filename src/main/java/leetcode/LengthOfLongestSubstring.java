package leetcode;

import java.util.HashMap;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        int abcabcbb = lengthOgLongestSubstring("abcdabcbb");
        System.out.println(abcabcbb);
    }
    public static int lengthOgLongestSubstring(String s){
        HashMap<Character,Integer> hashMap = new HashMap<>();
        int max = 0, pos = 0;
        for (int i = 0; i < s.length(); i++){
            pos = Math.max(pos,hashMap.getOrDefault(s.charAt(i),0)+1);
            hashMap.put(s.charAt(i),i);
            max = Math.max(max,i-pos+1);
        }
        return max;
       /* int i = 0,j = 0,max=0;
        Set<Character> set = new HashSet<>();
        while (j < s.length()){
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                max = Math.max(max,set.size());
            }else {
                set.remove(s.charAt(i++));
            }
        }
        return max;*/
    }
}
