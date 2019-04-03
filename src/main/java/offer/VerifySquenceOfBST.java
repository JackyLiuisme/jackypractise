package offer;

import java.util.Arrays;

public class VerifySquenceOfBST {
    public static boolean VerifySquenceOfBST(int [] sequence) {

        if (sequence.length == 0 || sequence.length == 1){
            return true;
        }

        int index = sequence[sequence.length-1],count=0,i=0;
        while (i < sequence.length && sequence[i] < index){
            i++;
        }
        count = i;
            while (i < sequence.length){
                if (sequence[i] < index){
                    return false;
                }
                i++;
            }
            return VerifySquenceOfBST(Arrays.copyOfRange(sequence,0,count))
                    ||  VerifySquenceOfBST(Arrays.copyOfRange(sequence,count,sequence.length-1));

    }

    public static void main(String[] args) {
        int [] array = {5,4,3,2,1};
        boolean b = VerifySquenceOfBST(array);
        System.out.println(b);
    }
}
