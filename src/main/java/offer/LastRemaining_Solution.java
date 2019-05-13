package offer;

public class LastRemaining_Solution {
    public int LastRemaining_Solution(int n, int m) {
        int count = n, step = 0,i = -1;
        int [] array = new int[n];
        while (count > 0){
            i++;

            if (i >= n){
                i = 0;
            }
            if (array[i] == -1){
                continue;
            }
            step++;
            if (step == m){
                step = 0;
                array[i] = -1;
                count--;
            }
        }
        return i;
    }
}
