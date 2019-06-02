package offer;

public class duplicate {
    public static void main(String[] args) {
        int [] array = {1,0,6,1,2,5,3};
        duplicate(array,array.length,new int[1]);
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
}
