public class Solution {
    public int numTrees(int n) {// n = 3 : dp[2] * dp[0] + dp[1] * dp[1] + dp[0] * dp[2]
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < i; j++){
                dp[i] += dp[j] * dp[i - 1 - j];
            }
            
        }
        return dp[n];
        
    }
}