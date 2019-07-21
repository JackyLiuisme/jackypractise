package offer;

import java.util.ArrayList;

public class printMatrix {
    public static void main(String[] args) {
        int [] [] matrix = {{1 ,2, 3, 4} ,{5,6, 7, 8}, {9,10, 11, 12} ,{13,14, 15, 16 }};
        ArrayList<Integer> list = printMatrix(matrix);
        for (int n:list
             ) {
            System.out.println(n);
        }
    }
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        int r1 = 0,r2 = matrix.length ;
        int l1 = 0,l2 = matrix[0].length ;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        if (matrix == null)
            return arrayList;
        int count = r2 * l2;
        while (count > 0){
            for (int i = l1; i < l2; i++){
                arrayList.add(matrix[r1][i]);
                count--;
            }
            r1++;
            if (count == 0)
                break;
            for (int i = r1; i < r2; i++){
                arrayList.add(matrix[i][l2-1]);
                count--;
            }
            l2--;
            if (count == 0)
                break;
            for (int i = l2-1; i >= l1; i--){
                arrayList.add(matrix[r2-1][i]);
                count--;
            }
            r2--;
            if (count == 0)
                break;
            for (int i = r2-1; i >= r1; i--){
                arrayList.add(matrix[i][l1]);
                count--;
            }
            l1++;
        }
        return arrayList;
    }
}


