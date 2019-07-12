package offer;

public class reOrderArray {
    public static void main(String[] args) {
        int [] nums = {2,3,1,5,4,6,7,8,10};
        reOrderArray(nums);
    }
    public static void reOrderArray(int [] array) {
       int left = 0,right = array.length -1;
       while (left < right){
           while ( array[left] % 2 == 1 && left < right){
               left++;
           }
           while (array[right] % 2 == 0 && left < right){
               right--;
           }
           int temp = array[left];
           array[left] = array[right];
           array[right] = temp;
       }
        for (int n :
                array) {
            System.out.println(n);
        }
    }
}
