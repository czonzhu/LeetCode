public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) return 0;
        int max = 0;
        for(int i = 1, valley = prices[0]; i < prices.length; i++){
            valley = Math.min(prices[i], valley);
            max = Math.max(max, prices[i] - valley);
        }
        return max;
    }
}