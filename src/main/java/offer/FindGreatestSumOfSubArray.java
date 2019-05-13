package offer;

public class FindGreatestSumOfSubArray {
    public static void main(String[] args) {
        int [] array = {6,-3,-2,7,-15,1,2,2};
        int i = FindGreatestSumOfSubArray(array);
        System.out.println(i);
    }
    public static int FindGreatestSumOfSubArray(int[] array) {
        int []temp = new int[array.length];
        int max = 0;
        temp[0] = array[0];
        for (int i = 1; i < array.length; i++){
            temp[i] = array[i] +(temp[i-1] > 0 ? temp[i-1] : 0);
            max = Math.max(max,temp[i]);
        }
        return max;
    }
}
