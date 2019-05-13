package offer;

public class NumberOf1Between1AndN_Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0, i  = 1;
        while (n / i != 0){
            int current = (n / i ) % 10;
            int before = n / (i *10);
            int after =n -  n /  i * i ;
            if (current == 0){
                count += before * i;
            }else if (current == 1){
                count += before * i + after + 1;
            }else {
                count += (before+1)  * i;
            }
            i *= 10;
        }
        return count;
    }
}
