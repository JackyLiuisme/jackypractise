package leetcode;

public class solve130 {
    public static void main(String[] args) {
        char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        solve(board);
        for (char[] s:board
             ) {
            for (char n:s
                 ) {
                System.out.println(n);
            }
        }
    }
    public static void solve(char[][] board) {
        int row = board.length  - 1;
        int col = board[0].length - 1;
        for (int i = 0; i <= row; i++) {
            if (board[i][0] == 'O'){
                help(board,i,0);
            }
            if (board[i][col] == 'O'){
                help(board,i,col);
            }
        }
        for (int i = 0; i <= col; i++) {
            if (board[0][i] == 'O'){
                help(board,0,i);
            }
            if (board[row][i] == 'O'){
                help(board,row,i);
            }
        }

        for (int i = 0; i <= row; i++){
            for (int j = 0; j <= col; j++){
                if (board[i][j] == '@'){
                    board[i][j] = 'O';
                }else {
                    board[i][j] = 'X';
                }
            }
        }

    }

    private static void help(char[][] board, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != 'O'){
            return;
        }
        board[row][col] ='@';
        help(board,row-1,col);
        help(board,row,col-1);
        help(board,row+1,col);
        help(board,row,col+1);
    }

}
