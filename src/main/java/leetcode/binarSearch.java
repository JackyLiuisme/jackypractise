package leetcode;

/**
 * todo
 * 在折断的升序数组中找到目标数的index,需要对target在左右哪一段升序数组中进行判断
 *                     if (targe < nums[mid] && targe >= nums[left])
 */
public class binarSearch {
    public static void main(String[] args) {
        int [] num = {4,5,6,7,0,1,2};
        int search = search(num, 2);
        System.out.println(search);
    }
    public static int search(int []nums ,int targe){
        int left = 0,right = nums.length-1;
        while (left <= right){
            int mid = (left + right)/2;
            if (nums[mid] == targe){
                return mid;
            }
            if (nums[mid] >= nums[left]){
                    if (targe < nums[mid] && targe >= nums[left]){
                        right = mid-1;
                    }else {
                        left = mid+1;
                    }
            }
            if (nums[mid] <= nums[left]){
                if (targe > nums[mid] && targe <= nums[left]){
                    left = mid+1;
                }else {
                    right = mid-1;
                }
            }
        }
        return -1;
    }

}
