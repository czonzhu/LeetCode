public class Solution{
	public boolean exist(char[][] board, String word){
		if(word == null || word.length() == 0) return true;
		if(board == null || board.length == 0 || board[0].length == 0) return false;
		int m = board.length, n = board[0].length;
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				if(board[i][j] == word.charAt(0)){
					if(floodFill(board, word, 0, i, j)) return true; 
				}
			}
		}
		return false;
	}
	public boolean floodFill(char[][] board, String word, int index, int i, int j){
		int m = board.length, n = board[0].length;
		if(index == word.length()) return true;
		if(i < 0 || i >= m || j < 0 || j >= n || word.charAt(index) != board[i][j]) return false;
		board[i][j] = '#';// dont forget to block the back road
		boolean r = floodFill(board, word, index + 1, i + 1, j) || floodFill(board, word, index + 1, i - 1, j) || floodFill(board, word, index + 1, i, j + 1)||floodFill(board, word, index + 1, i, j - 1);
		board[i][j] = word.charAt(index);
		return r;
	}
}