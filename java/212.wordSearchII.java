public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> rst = new ArrayList<String>();
        StringBuilder path = new StringBuilder();
        if(board == null || board.length == 0 || board[0].length == 0) return rst;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                for(String str : words){
                    if(board[i][j] == str.charAt(0) && !rst.contains(str)){
                        dfs(board, str, rst, i, j, 0);
                    }
                }
            }
        }
        return rst;
    }
    
    public void dfs(char[][] board, String word, List<String> rst,  int i, int j, int index){
        int m = board.length, n = board[0].length;
        if(index == word.length()){
           rst.add(word);
           return;
        } 
        if(i < 0 || i >= m || j < 0 || j >= n || board[i][j] != word.charAt(index)) return;
        board[i][j] = '0';
        dfs(board, word, rst, i + 1, j, index + 1);
        dfs(board, word, rst, i - 1, j, index + 1);
        dfs(board, word, rst, i, j + 1, index + 1);
        dfs(board, word, rst, i, j - 1, index + 1);
        board[i][j] = word.charAt(index);
        return;
    }
}