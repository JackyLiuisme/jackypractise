package company.practise18;

import java.util.ArrayList;
import java.util.Scanner;

public class PinDuoDuo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int offset = scanner.nextInt();
        int n = scanner.nextInt();
        int l1 = scanner.nextInt();
        int l2 = scanner.nextInt();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list.get(0).add(2);
        int sum = offset + n;
        int rest = l1 + l2;
        int start1,end1,start2,end2;
        if (offset >= l1){
            start1 = l1;
            end1 = l1;
            start2 =  offset - l1 ;
            end2 = offset + n - l1;
        }else if (sum > l1 && offset < l1){
            start1 = offset;
            end1 = l1;
            start2 = 0;
            end2 = sum - l1;
        }else {
            start1 = offset;
            end1 = sum;
            start2 = 0;
            end2 = 0;
        }
        System.out.println( start1+" " + end1 + " " + start2 + " " + end2 );
    }
}
