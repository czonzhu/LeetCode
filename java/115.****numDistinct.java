public class Solution {
    public int numDistinct(String s, String t) {
        int ls = s.length(), lt = t.length();
        int[][] dp = new int[ls + 1][lt + 1];
        for(int i = 0; i <= ls; i++){
            dp[i][0] = 1;// "a" in "a" = "a" in ""(0) + "" in ""(1) as a ==
        }
        for(int i = 1; i <= ls; i++){
            for(int j = 1; j <= lt; j++){// rab  in  rabb = rab in rab(not use the current b) + ra in rab(use the current b) ;   rab in rabc == rab in rab
                dp[i][j] = dp[i - 1][j] + (s.charAt(i - 1) == t.charAt(j - 1) ? dp[i - 1][j - 1]: 0);
            }
            
        }
        return dp[ls][lt];
    }
}