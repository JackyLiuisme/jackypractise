package leetcode;
/*
Example 1:
Input:
11110
11010
11000
00000

Output: 1

Example 2:
Input:
11000
11000
00100
00011
 */
public class NumIsland {
    public static void main(String[] args) {

    }
        private int n;
        private int m;

        public int numIslands(char[][] grid) {
            int count = 0;
            n = grid.length;
            m = grid[0].length;
            for (int i = 0; i < grid.length; i++){
                for (int j = 0; j < grid[0].length; j++){
                        if (grid[i][j] != '0'){
                            putToZero(grid,i,j);
                            count++;
                        }
                }
            }
            return count;

        }

    private void putToZero(char[][] grid, int i, int j) {
            if (grid[i][j] == '0' || i < 0 || j < 0 || i >= grid.length || j >= grid[0].length){
                return;
            }
            grid[i][j] = '0';
            putToZero(grid,i,j-1);
            putToZero(grid,i+1,j);
            putToZero(grid,i,j+1);
            putToZero(grid,i-1,j);
    }
          /*  int count = 0;
            n = grid.length;
            if (n == 0) return 0;
            m = grid[0].length;
            for (int i = 0; i < n; i++){
                for (int j = 0; j < m; j++)
                    if (grid[i][j] == '1') {
                        DFSMarking(grid, i, j);
                        ++count;
                    }
            }

            return count;
        }

        private void DFSMarking(char[][] grid, int i, int j) {
            if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') return;
            grid[i][j] = '0';
            DFSMarking(grid, i + 1, j);
            DFSMarking(grid, i - 1, j);
            DFSMarking(grid, i, j + 1);
            DFSMarking(grid, i, j - 1);
        }*/
    }
