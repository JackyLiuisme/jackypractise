package offer;

/**
 * Example 1:
 *
 * Input: [2,2,1]
 * Output: 1
 * Example 2:
 *
 * Input: [4,1,2,1,2]
 * Output: 4
 */
public class SingleNumber {
    public static int singleNumber(int[] A) {
      /*  int count = 1,num = nums[0];
        for (int  i = 1; i < nums.length; i++){
            if(count == 0){
                num = nums[i];
                count++;
            }else {
                if (nums[i] == num){
                    count++;
                }else {
                    count--;
                }
            }
        }*/
      if (A.length == 0){
          return 0;
      }
      int temp = A[0];
       for (int i = 1; i < A.length; i++){
           temp = temp ^ A[i];
       }
     return temp;
    }

    public static void main(String[] args) {
        int [] array = {3,3,2,1,1,5,5};
        System.out.println(singleNumber(array));
    }
}
