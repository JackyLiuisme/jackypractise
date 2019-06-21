package leetcode;

public class NumIsland {
    public int numLisland(char[][] grid){
        int row = grid.length;
        int count = 0;
        int col = grid[0].length;
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                Mark(grid,i,j);
                count++;
            }
        }
        return count;
    }
    public void Mark(char[][] grid,int row,int col){
        if (row<0||col<0||row>=grid.length||col <= grid[0].length||grid[row][col]=='0' ){
            return;
        }
        grid[row][col] = '0';
        Mark(grid,row-1,col);
        Mark(grid,row+1,col);
        Mark(grid,row,col-1);
        Mark(grid,row,col+1);
    }
}
