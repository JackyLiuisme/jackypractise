package offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {
      /* String  s = "anagram", t = "nagaram";
       int [] nums = {2,3,1,4,5};
        System.out.println(partion(nums,0,nums.length-1));*/
        System.out.println(countPrimes(2));
        boolean flag = isPowerOfThree(-3);
        System.out.println(flag);
    }
    public static boolean isPowerOfThree(int n) {
        if(n == 0 ){
            return false;
        }
        if(n < 0){
            n = 0-n;
        }
        while(n > 1){
            if(n % 3 == 0){
                n = n / 3;
            }else{
                return false;
            }
        }
        return true;
    }
    public static int countPrimes(int n) {
        if(n == 1){
            return 0;
        }
        int count = 0;
        for(int i = 2; i <= n; i++){
            if(isPrime(i)){
                count++;
            }
        }
        return count;
    }
    public static Boolean isPrime(int n){
        switch(n){
            case 2 :
                return true;
            case 3:
                return true;

            case 5:return true;

            case 7:return true;

        }
        if(n % 2 == 0 || n % 3 == 0 || n % 5 == 0 || n % 7 == 0 ){
            return false;
        }
        return true;
    }


    public static boolean isHappy(int n) {
        int x = n;
        int y = n;
        while(x>1){
            x = split(x) ;
            if(x==1) return true ;
            y = split(split(y));
            if(y==1) return true ;

            if(x==y) return false;
        }
        return true ;
    }
    public static int split(int n){
        int result = 0;
        while(n > 0){
            int temp = n % 10;
            result += temp*temp;
            n = n / 10;
        }
        return result;
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        if (numRows == 0){
            return lists;
        }
        List<Integer> list = new ArrayList<>();
        list.add(1);
        lists.add(list);
        for (int i = 1; i < numRows; i++){
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for (int j = 1; j < i; j++){
                Integer num = lists.get(i-1).get(j-1) + lists.get(i-1).get(j);
                temp.add(num);
            }
            temp.add(1);
            lists.add(temp);
        }
        return lists;
    }







    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null){
            return null;
        }
        return null;
    }
    public static int partion(int [] nums,int left,int right){
        int temp = nums[left];
        while(left < right){
            while(left < right &&nums[right] >= temp){
                right--;
            }
            nums[left] = nums[right];
            while(left < right && nums[left] < temp) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = temp;
        return left;
    }
    public static int majorityElement(int[] nums) {
        int count = 0,temp = nums[0];
        for(int i = 0; i < nums.length; i++){
            if(count == 0){
                count++;
                temp = nums[i];
            }else {
                if(temp == nums[i]){
                    count++;
                }else{
                    count--;
                }
            }
        }
        count = 0;
        for(int i = 0; i < nums.length; i++){
            if(temp == nums[i]){
                count++;
            }
        }
        return temp;
    }
    public static boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> hash = new HashMap();
        char[] sTemp = s.toCharArray();
        char[] tTemp = t.toCharArray();
        if(sTemp.length != tTemp.length){
            return false;
        }
        for(int i = 0; i < sTemp.length; i++){
            hash.put(sTemp[i],hash.getOrDefault(sTemp[i],0)+1);
        }
        for(int i = 0; i < tTemp.length; i++){
            Integer n = hash.get(tTemp[i]);
            if(n == 0) {
                return false;
            } else{
                hash.put(tTemp[i],n-1);
            }
        }
        return true;
    }
}
