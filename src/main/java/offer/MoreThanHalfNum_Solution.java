package offer;

public class MoreThanHalfNum_Solution {
    public static void main(String[] args) {
        int [] array = {1,2,3,2,2,2,5,4,2};
        int n = MoreThanHalfNum_Solution(array);
        System.out.println(n);
    }
    public static int MoreThanHalfNum_Solution(int [] array) {
        int count = 1,temp = array[0];
        for (int i = 1; i < array.length; i++){
            if (count == 0){
                temp = array[i];
                count++;
            }else {
                if (array[i] == temp){
                    count++;
                }else {
                    count--;
                }
            }
        }
        count = 0;
        for (int i =  0; i < array.length; i++){
            if (array[i] == temp){
                count++;
            }
        }
        if (count > array.length / 2){
            return temp;
        }else {
            return 0;
        }

    }
}
