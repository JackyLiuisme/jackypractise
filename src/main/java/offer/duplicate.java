package offer;

/**
 * Example 1:
 *
 * Input: [1,3,4,2,2]
 * Output: 2
 * Example 2:
 *
 * Input: [3,1,3,4,2]
 * Output: 3
 * Note:
 *
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 */
public class duplicate {
    public static void main(String[] args) {
        int [] array = {0,4,6,1,5,1,3};
        duplicate(array,array.length,array);
        int duplicate = findDuplicate(array);
        System.out.println(duplicate);
    }
    public static boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers == null || length <= 0) {
            return false;
        }

            for (int i = 0; i < length; i++){
            while (numbers[i] != i){
                if (numbers[i] == numbers[numbers[i]]){
                    duplication[0] = numbers[i];
                    return true;
                }
                int temp = numbers[i];
                numbers[i] = numbers[temp];
                numbers[temp] = temp;
            }
        }

        return false;
    }

    public static int findDuplicate(int[] nums) {
       int fast=0,low=0;
       do{
           fast = nums[nums[fast]];
           low = nums[low];
       }while (fast != low);
       low = 0;
       do{
           low = nums[low];
           fast = nums[fast];
       }while (fast != low);
       return low;
    }
}
