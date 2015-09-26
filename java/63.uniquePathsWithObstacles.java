public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0; i <= m; i++) dp[i][0] = 0;
        for(int i = 0; i <= n; i++) dp[0][i] = 0;
        dp[1][0] = 1;
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                dp[i][j] = obstacleGrid[i - 1][j - 1] != 1 ? dp[i - 1][j] + dp[i][j - 1] : 0;
            }
        }
        return dp[m][n];
    }
}