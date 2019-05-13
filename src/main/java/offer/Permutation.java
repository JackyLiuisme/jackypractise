package offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

//todo
public class Permutation {
    public static void main(String[] args) {
        ArrayList<String> abc = Permutation("abc");
        for (String s:abc
             ) {
            System.out.println(s);
        }
    }
    public static ArrayList<String > Permutation(String str) {

        ArrayList<String> arrayList = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        Sort(str.toCharArray(),set ,0);
        arrayList.addAll(set);
        Collections.sort(arrayList);
        return arrayList;
    }
    public static void Sort(char[] array, HashSet set,int k){
        if (k == array.length-1){
            set.add(new String(array));
        }
        for (int i = k; i  < array.length; i++){
            swap(array,i,k);
            Sort(array,set,k+1);
            swap(array,i,k);
        }

    }
    public static void swap(char [] chars, int left, int right){
        char temp = chars[left];
        chars[left] = chars[right];
        chars[right] = temp;
    }


/*    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> re = new ArrayList<String>();
        if (str == null || str.length() == 0) {
            return re;
        }
        HashSet<String> set = new HashSet<String>();
        fun(set, str.toCharArray(), 0);
        re.addAll(set);
        Collections.sort(re);
        return re;
    }
    static void  fun(HashSet<String> re, char[] str, int k) {
        if (k == str.length - 1) {
            re.add(new String(str));
            return;
        }
        for (int i = k; i < str.length; i++) {
            swap(str, i, k);
            fun(re, str, k + 1);
            swap(str, i, k);
        }
    }
    static void swap(char[] str, int i, int j) {
        if (i != j) {
            char t = str[i];
            str[i] = str[j];
            str[j] = t;
        }
    }*/
}
