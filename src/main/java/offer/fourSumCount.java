package offer;

import java.util.HashMap;

/**
 * 从A,B,C,D四个数组。找出相加等于零的组合数
 */
public class fourSumCount {
    public static void main(String[] args) {
        int [] A = {1,2},B ={-2,-1},C={-1,2},D={0,2};
        int N = fourSumCount(A, B, C, D);
        System.out.println(N);
    }
    public static int fourSumCount(int []A,int []B,int []C ,int []D){
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i = 0; i < A.length; i++){
            for (int j = 0; j < B.length; j++){
                map.put(A[i]+B[j],map.getOrDefault(A[i]+B[j],0)+1);
            }
        }
        int result = 0;
        for (int i = 0; i < C.length; i++){
            for (int j = 0; j < D.length; j++){
                result += map.getOrDefault(-(C[i]+D[j]),0);
            }
        }
        return result;
    }
}
