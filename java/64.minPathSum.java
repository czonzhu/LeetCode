public class Solution {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0; i <= m; i++) dp[i][0] = Integer.MAX_VALUE;
        for(int j = 0; j <= n; j++) dp[0][j] = Integer.MAX_VALUE;
        dp[1][0] = 0;// make it right
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
            }
        }
        return dp[m][n];
        
    }
}