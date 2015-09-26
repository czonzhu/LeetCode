public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> rst = new ArrayList<List<String>>();
        List<String> board = new ArrayList<String>();
        int[] col = new int[n], dio1 = new int[2 * n], dio2 = new int[2 * n];
        helper(rst, board, col, dio1, dio2, n);
        return rst;
    }
    
    public void helper(List<List<String>> rst, List<String> board, int[] col, int[] dio1, int[] dio2, int n){
        if(board.size() == n){
            rst.add(new ArrayList<String>(board));
            return;
        }
            
            int r = board.size();
            char[] cstr = new char[n];// transfer to cstr to make it mutable
            Arrays.fill(cstr, '.');//this position for the char[] make it the most efficient.
            for(int c = 0; c < n; c++){
                if(col[c] != 1 && dio1[n + r - c] != 1 && dio2[r + c] != 1){
                    cstr[c] = 'Q';
                    col[c] = 1; dio1[n + r - c] = 1; dio2[r + c] = 1;
                    board.add(new String(cstr));// toString() is used by sb
                    helper(rst, board, col, dio1, dio2, n);
                    board.remove(board.size() - 1);
                    cstr[c] = '.';
                    col[c] = 0; dio1[n + r - c] = 0; dio2[r + c] = 0;
                }
            }
        
        return;
    }
}