public class Solution{
	public int numIslands(char[][] grid){
		if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
		int m = grid.length, n = grid[0].length;
		int count = 0;
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				if(grid[i][j] == '1'){
					floodFill(grid, '1', 'x', i, j);
					count++;
				}
			}
		}
		return count;
	}

	public void floodFill(char[][] grid, char from, char to, int i, int j){
		int m = grid.length, n = grid[0].length;
		if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != from) return;
		grid[i][j] = to;
		floodFill(grid, from, to, i + 1, j);
        floodFill(grid, from, to, i - 1, j);
        floodFill(grid, from, to, i, j - 1);
        floodFill(grid, from, to, i, j + 1);
        return;
	}
}