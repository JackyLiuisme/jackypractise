package basic.SortAlogrithm;

public class HeapSort {
    public static void main(String[] args) {
        int[] array = {4, 2, 7, 5, 6, 9, 1};
        heapSort(array);
        for (int i :array
             ) {

            System.out.println(i);
        }
    }
    public static void heapSort(int [] array){
        for (int i = array.length / 2 - 1; i >= 0; i--){
            adjust(array,i,array.length-1);
        }
        for (int i = array.length-1; i >= 0; i--){
            System.out.println(array[0]);
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            adjust(array,0,i-1);
        }
    }
    public static void adjust(int [] array , int pos ,int length){
        int temp = array[pos];
        int chrild = 0;
        for (;pos*2 + 1 <= length; pos = chrild){
            chrild = pos * 2 + 1;
            if (chrild < length && array[chrild] < array[chrild+1]){
                chrild++;
            }
            if (array[chrild] > temp){
                array[pos] = array[chrild];
            }else {
                break;
            }
        }
        array[pos] = temp;
    }
}
