package offer;

import java.util.ArrayList;

public class GetLeastNumbers_Solution {
    public static void main(String[] args) {
        int []array = {4,5,1,6,2,7,3,8};
        ArrayList<Integer> list = GetLeastNumbers_Solution(array, 8);
    }
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input == null || k > input.length){
            return list;
        }
      for (int i = (k / 2) - 1; i >= 0; i--){
          adjust(input,i,k-1);
      }
      for (int i = k ; i < input.length; i++){
          if (input[i] < input[0]){
              int temp = input[0];
              input[0] = input[i];
              input[i] = temp;

          adjust(input,0,k-1);
          }
      }

      for (int i = 0; i < k ; i++){
          list.add(input[i]);
          System.out.println(input[i]);
      }

        return list;
    }
    public static void adjust(int[] array,int pos,int length){
        int temp = array[pos];
        int chirld = 0;
        for (; pos*2 + 1<= length;  pos = chirld){
            chirld = pos * 2 + 1;
            if ( chirld  < length && array[chirld] < array[chirld+1] ){
                chirld++;
            }
            if (array[chirld] > temp){
                array[pos] = array[chirld];
            }else {
                break;
            }
        }
        array[pos] = temp;
    }

}
