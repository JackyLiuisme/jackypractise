package offer;




public class InversePairs {
    public static int pairsnum = 0;

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,0};
        int i = InversePairs(nums);
    }
    public static int InversePairs(int [] array) {
            int [] temp = new int[array.length];
        int n = mergeSort(array, temp, 0, array.length - 1);
        System.out.println(n);
        return n;
    }

    public static int mergeSort(int[] array,int []temp, int left,int right){
        if (left == right) {
            return 0;
        }
        int  mid = (left + right) / 2;
        mergeSort(array,temp,left,mid);
        mergeSort(array,temp,mid+1,right);
        return merge(array,temp,left,mid,right);
    }
    public static int merge(int[] array,int []temp, int left,int mid,int right){
        int count = 0;
        int i = mid,j = right;
        while (i >= left && j >= mid+1){
            if (array[i] > array[j]){
                pairsnum += j - mid;
                temp[count++] = array[i--];
            }else {
                temp[count++] = array[j--];
            }
        }
        while (i >=left){
            temp[count++] = array[i--];
        }
        while (j >= mid+1){
            temp[count++] = array[j--];
        }
        while (left <= right){
            array[left++] = temp[--count];
        }
        return pairsnum;
    }

}
