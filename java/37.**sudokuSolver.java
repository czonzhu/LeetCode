public class Solution {
    public void solveSudoku(char[][] board) {
         if(board.length != 9 || board[0].length != 9) return;
         solve(board);
    }
    
    public boolean solve(char[][] board){//Vital to take a solve boolean
        for(int i = 0; i < 9; i++){
             for(int j = 0; j < 9; j++){
                 if(board[i][j] != '.') continue;// Vital line!!!!!!!!!!!!!!!
                 for(char c = '1'; c <= '9'; c++){
                     board[i][j] = c;
                     if(validSudoku(board) && solve(board)) return true;// not continue, it's true
                     board[i][j] = '.';
                 }
                 return false;// when all characters are tried, return false
             }
         }
         return true;
    }
    public boolean validSudoku(char[][] board){
        if(board.length != 9 || board[0].length != 9) return false;
        boolean[] exist = new boolean[9];
        
        for(int i = 0; i < 9; i++){
            exist = new boolean[9];
            for(int j = 0; j < 9; j++){
                if(!process(board, i, j, exist)) return false;
            }
        }
        
        for(int j = 0; j < 9; j++){
            exist = new boolean[9];
            for(int i = 0; i < 9; i++){
                if(!process(board, i, j, exist)) return false;
            }
        }
        
        for(int i = 0; i < 9; i+=3){
            for(int j = 0; j < 9; j+=3){
                exist = new boolean[9];
                for(int k = 0; k < 9; k++){
                    if(!process(board, i + k / 3, j + k % 3, exist)) return false;
                }
            }
        }
        return true;
    }
    public boolean process(char[][] board, int i, int j, boolean[] exist){
                char cur = board[i][j];
                int digit = cur - '0';
                if(cur == '.') return true;
                if(digit > 9 || digit < 1) return false;
                if(exist[digit - 1] == true) return false;
                exist[digit - 1] = true;
                return true;
    }
}