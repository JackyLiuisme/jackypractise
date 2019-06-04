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
        boolean [] flag = new boolean[rows*cols];
        jude(0,0,threshold,rows,cols,flag);


        return index;
    }

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

    }
    private static int numSum(int i){
        int sum = 0;
        do {
            sum += i%10;
        }while ((i = i / 10)>0);
        return sum;
    }


    public static void main(String[] args) {
        int i = movingCount(15,20,20);
        System.out.println(i);
    }
}
