public class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length < 3 || board[0].length < 3) return;
        fillBorder(board, 'O', 'P');
        replace(board, 'O', 'X');
        replace(board, 'P', 'O');
        return;
    }
    
    public void floodFill(char[][] board, char from, char to, int i, int j){
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != from) return;
        board[i][j] = to;
        floodFill(board, from, to, i + 1, j);
        floodFill(board, from, to, i - 1, j);
        floodFill(board, from, to, i, j + 1);
        floodFill(board, from, to, i, j - 1);
    }
    
    public void fillBorder(char[][] board, char from, char to){
        int m = board.length, n = board[0].length;
        for(int i = 0; i < m; i++){
            if(board[i][0] == from) floodFill(board, from, to, i, 0);
            if(board[i][n - 1] == from) floodFill(board, from, to, i, m - 1);
        }
        for(int j = 1; j < n - 1; j++){
            if(board[0][j] == from) floodFill(board, from, to, 0, j);
            if(board[m - 1][j] == from) floodFill(board, from, to, m - 1, j);
        }
    }
    
    public void replace(char[][] board, char from, char to){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == from)
                    board[i][j] = to;
            }
        }
    }
}