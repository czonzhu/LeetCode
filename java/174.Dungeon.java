public class Solution{
	public int calculateMinimumHP(int[][] dungeon){
		// 镀右边法
		if(dungeon == null || dungeon.length == 0) return 1;
		int m = dungeon.length, n = dungeon[0].length;
		int[][] HP = new int[m + 1][n + 1];
		for(int i = 0; i < m; i++) HP[i][n] = Integer.MAX_VALUE;
		for(int j = 0; j < n; j++) HP[m][j] = Integer.MAX_VALUE;
		HP[m][n - 1] = 1;
		for(int i = m - 1; i >= 0; i--){
			for(int j = n - 1; j >= 0; j--){
				HP[i][j] = Math.max(1, Math.min(HP[i + 1][j], HP[i][j + 1]) - dungeon[i][j]);
			}
		}
		return HP[0][0];
	}
}