package basic.SortAlogrithm;

public class quickSort {
    public static void main(String[] args) {
        int [] array = {4,2,7,5,6,9,1};
        quickSort(array,0,array.length-1);
        for (int i :array
             ) {
            System.out.println(i);
        }
    }
    public static void quickSort(int [] array,int left, int right){
        if (left >= right){
            return;
        }
        int partion = partion(array, left, right);
        quickSort(array,left,partion-1);
        quickSort(array,partion+1,right);
    }
    public static int partion(int []array,int left,int right){
        int temp = array[left];
        while (left < right){
            while (left < right && array[right] >= temp ){
                right--;
            }
            array[left] = array[right];
            while (left < right &&array[left] < temp){
                left++;
            }

            array[right] = array[left];
        }
        array[left] = temp;
        return left;
    }

     /*   if (left < right){
            int partion = partion(array, left, right);
            quickSort(array,left,partion-1);
            quickSort(array,partion+1,right);
        }
    }
    public static int partion(int [] array , int left ,int right){

        int temp = array[left];
        while (left < right){
            while (left < right && array[right] > temp) {
                right--;
            }
            array[left] = array[right];
            while (left < right && array[left] < temp){
                left++;
            }
            array[right] = array[left];
        }
        array[left] = temp;

            return left;
    }*/
}
