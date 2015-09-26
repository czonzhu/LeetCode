public class Solution{
	public int maxProfit(int k, int[] prices){
		int n = prices.length;
		if(prices == null || prices.length == 0) return 0;
		int[][] f = new int[k + 1][n];
		int maxPro = 0;
		for(int i = 1; i <= k; i++){
			int tmpMax = -prices[0];
			for(int j = 1; j < n; j++){
				f[i][j] = Math.max(f[i][j - 1], tmpMax + prices[j]);
				tmpMax = Math.max(tmpMax, f[i - 1][j - 1] - prices[j]);//Valley
				maxPro = Math.max(maxPro, f[i][j]);
			}
		}
		return maxPro;
	}
}