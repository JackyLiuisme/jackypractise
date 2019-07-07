package company.practise18;

import java.util.Scanner;

public class pinduoduog {

    static  int MaxNum = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        char [] [] array = new char[n][m];
        int x=0,y=0;
        String temp1 = scanner.nextLine();
        for (int i = 0; i < n; i++){
            String temp = scanner.nextLine();
            char[] chars = temp.toCharArray();
            for (int j = 0; j < m; j++){
                array[i][j] = chars[j];
                if (chars[j] == '2'){
                    x = i;
                    y = j;
                }
            }
        }
        getKey(array,x,y,m,n,0);

    }
    public static boolean getKey(char[][] array,int x,int y,int m,int n,int count){
        if (x < 0 || y < 0 || x >=n || y >= n || array[x][y] == '0'){
            return false;
        }

        if (array[x][y] >= 'a' && array[x][y] <= 'z'){
            if (count < MaxNum){
                MaxNum = count;
            }
            return true;
        }
       return getKey(array,x+1,y,m,n,count+1) ||
        getKey(array,x,y+1,m,n,count+1) ||
        getKey(array,x-1,y,m,n,count+1)||
        getKey(array,x,y-1,m,n,count+1);



    }
}
