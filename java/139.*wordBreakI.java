public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        // Related: scramble string, count j back from 0 to i - 1
        // DP relation: If there is word in dict and the sequence before the word is true, then the whole sequence is true;
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(int j = i - 1; j >= 0; j--){
                if(dp[j] && wordDict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}