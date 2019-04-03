package offer;

import java.util.ArrayList;
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
    private static ArrayList<String > Permutation(String str){
        ArrayList<String> arrayList = new ArrayList<String>();
        HashSet<String> set = new HashSet<String>();
        char[] array = str.toCharArray();
        sort(set,array,0);
        arrayList.addAll(set);
        return arrayList;
    }
    private static void sort(HashSet<String> set , char[] array,int k){
        if (k == array.length){
            set.add(new String(array));
        }
        for (int i = k; i < array.length; i++){
            swap(array,i,k);
            sort(set,array,k+1);
            swap(array,k,i);
        }
    }
    private static void swap(char [] array,int left ,int right){
            char temp = array[left];
            array[left] = array[right];
            array[right] = temp;
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
