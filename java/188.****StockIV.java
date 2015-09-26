public class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if(prices == null || prices.length == 0) return 0;
        if(k > n / 2) return quickSolve(prices);
        int[][] release = new int[k + 1][n + 1];
        for(int i = 1; i <= k; i++){
            int hold = Integer.MIN_VALUE;
            for(int j = 1; j <= n; j++){
                release[i][j] = Math.max(release[i][j - 1], hold + prices[j - 1]);
                hold = Math.max(release[i - 1][j - 1] - prices[j - 1], hold);
            }
        }
        return release[k][n];
    }
    
    private int quickSolve(int[] prices){
        int rst = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > prices[i - 1]) rst += prices[i] - prices[i - 1];
        }
        return rst;
    }
}