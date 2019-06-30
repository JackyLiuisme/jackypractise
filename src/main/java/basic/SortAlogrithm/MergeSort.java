package basic.SortAlogrithm;

public class MergeSort {
    public static void main(String[] args) {
         int[] array = {4, 2, 7, 5, 6, 9, 1};
         Sort(array);

        for (int i:array
             ) {
            System.out.println(i);
        }
    }
    public static void Sort(int [] array) {
        int[] temp = new int[array.length];
        Sort(array,temp,0,array.length-1);
    }
    public static void Sort(int[] array, int[] temp, int left,int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            Sort(array, temp, left, mid);
            Sort(array, temp, mid + 1, right);
            merge(array, temp, left, mid, right);
        }
    }
    public static void merge(int [] array, int [] temp, int left, int mid, int right) {
        int start = left, end = mid + 1,t = 0;
        while (start <= mid && end <= right) {
            if (array[start] < array[end]) {
                temp[t++] = array[start++];
            }else {
                temp[t++] = array[end++];
            }
        }
        while (start <= mid){
            temp[t++] = array[start++];
        }
        while (end <= right){
            temp[t++] = array[end++];
        }
          t = 0;
        while (left <= right){
            array[left++] = temp[t++];
        }
    }










       /* int [] temp = new int[array.length];
        Sort(array,temp,0,array.length-1);
    }
    public static void Sort(int [] array,int [] temp,int left, int right){
        if (left < right) {
            int mid = (left + right) / 2;
            Sort(array, temp, left, mid );
            Sort(array, temp, mid+1 , right);
            Merge(array, temp, left, mid, right);
        }
    }

    public static void Merge(int[] array,int [] temp,int left, int mid ,int right ){
        int low = left,high = mid+1,t = 0;
        while (low <= mid && high <= right){
            if (array[low] < array[high]){
                temp[t++] = array[low++];
            }else {
                temp[t++] =array[high++];
            }
        }
        while (low <= mid){
            temp[t++] = array[low++];
        }
        while (high <= right){
            temp[t++] = array[high++];
        }
        t = 0;
     while (left <= right){
         array[left++] = temp[t++];
     }
*/
          /*int i = left,j = mid+1,t = 0;

              while (i <= mid && j <= right){
                  if (array[i] <= array[j]){
                      temp[t++] = array[i++];
                  }else {
                      temp[t++] = array[j++];
                  }
              }
             while (i <= mid){
                 temp[t++] = array[i++];
             }
             while (j <= right){
                 temp[t++] = array[j++];
             }
             t = 0;
             while (left <= right){
                 array[left++] =  temp[t++];
             }*/


}
