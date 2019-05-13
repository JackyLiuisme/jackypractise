package offer;

public class GetUglyNumber_Solution {
    public int GetUglyNumber_Solution(int index) {
        int [] array = new int[index];
        int t2 = 0,t3 = 0,t5 = 0;
        array[0] = 1;
        for (int i = 1; i < index; i++){
            array[i] = Math.min(array[t2]*2,Math.min(array[t3]*3,array[t5]*5));
            if (array[t2] == array[i] ) {
                t2++;
            }
            if (array[t3] == array[i] ) {
                t3++;
            }
            if (array[t5] == array[i] ) {
                t5++;
            }

        }
        return array[index-1];

    }
}