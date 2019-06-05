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
    public int singleNumber(int[] nums) {
        int count = 1,num = nums[0];
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
        }
        return num;
    }
}
