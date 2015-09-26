public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board.length != 9 || board[0].length != 9) return false;
        int m = board.length, n = board[0].length;
        boolean[] exist = new boolean[9];
        
        for(int i = 0; i < 9; i++){
            exist = new boolean[9];
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.') continue;
                if(exist[board[i][j] - '1'] == true) return false;
                exist[board[i][j] - '1'] = true;
            }
        }
        
        for(int j = 0; j < 9; j++){
            exist = new boolean[9];
            for(int i = 0; i < 9; i++){
                if(board[i][j] == '.') continue;
                if(exist[board[i][j] - '1'] == true) return false;
                exist[board[i][j] - '1'] = true;
            }
        }
        
        for(int i = 0; i < 9; i+=3){// Pay special attention to += 3
            for(int j = 0; j < 9; j+=3){
                exist = new boolean[9];
                for(int k = 0; k < 9; k++){// The use of k.
                    if(board[i + k % 3][j + k / 3] == '.') continue;
                    if(exist[board[i + k % 3][j + k / 3] - '1'] == true) return false;
                    exist[board[i + k % 3][j + k / 3] - '1'] = true;
                }
            }
        }
        
        return true;
    }
}