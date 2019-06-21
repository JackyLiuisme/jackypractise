package offer;

/**
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
 * 每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），
 * 因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 *
 * 进行递归记录，递归的条件是不能越界，不能违规
 *
 */
public class movingCount {
     static int index = 0;
    public static int movingCount(int threshold, int rows, int cols)
    {
        int [][] flag = new int[rows][cols];

       return judge(flag,threshold,0,0,rows,cols);
    }

    public static int judge(int[][] flag,int threshold,int i,int j,int row,int cols){
        if (i < 0 || j < 0 || j >= cols || i >= row|| (split(i)+split(j)) > threshold || flag[i][j]==1){
            return 0;
        }

        flag[i][j] = 1;
        index++;
             judge(flag,threshold,i+1,j,row,cols);
                    judge(flag,threshold,i-1,j,row,cols);
                judge(flag,threshold,i,j+1,row,cols);
        judge(flag,threshold,i,j-1,row,cols);
             return index;
    }

    public static int split(int num){
        int count = 0;
        while (num != 0){
            count += num % 10;
            num = num / 10;
        }
        return count;
    }





/*
    public static void jude(int i,int j,int threshold,int row,int cols,boolean[]flag){
        if (i < 0 || j < 0 || j >= cols || i >= row || (numSum(i) +numSum(j)) > threshold || flag[i*cols+j]){
            return;
        }
        flag[i*cols+j] = true;
        index++;
        jude(i+1,j,threshold,row,cols,flag);
        jude(i-1,j,threshold,row,cols,flag);
        jude(i,j+1,threshold,row,cols,flag);
        jude(i,j-1,threshold,row,cols,flag);

    }*/
    private static int numSum(int i){
        int sum = 0;
        do {
            sum += i%10;
        }while ((i = i / 10)>0);
        return sum;
    }

    public static int movingCount1(int threshold, int rows, int cols)
    {
        int [][] flag = new int[rows][cols];
        return count(threshold,rows,cols,0,0,flag);
    }

    public static int  count(int limit,int row,int col, int r ,int c,int[][]flag){

        if (r < 0 || c < 0 || r >= row || c >= col || (flag[r][c] == 1 )|| (get(r) + get(c) > limit)){
            return 0;
        }
        flag[r][c] = 1;
        return  count(limit,row,col,r+1,c,flag) + count(limit,row,col,r,c+1,flag) + count(limit,row,col,r-1,c,flag) +
                count(limit,row,col,r,c-1,flag) + 1 ;
    }
    private static int get(int num){
        int count = 0;
        while (num != 0){
            count += num % 10;
            num = num / 10;
        }
        return count;
    }

    public static void main(String[] args) {
        int i = movingCount(5,10,10);
      //  int i = split(110);
        System.out.println(i);
    }
}
