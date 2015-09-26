public class Solution{
	//Very tricky 
	public int longestValidParentheses(String s){
		if(s == null || s.length() == 0) return 0;
		int[] dp = new int[s.length()];
		int maxLen = 0;
		for(int i = 1;  i < s.length(); i++){// pay attention to i = 1
			int match = i - dp[i - 1] - 1;
			if(match >= 0 && s.charAt(i) == ')' && s.charAt(match) == '('){// pay attention to this basic condition
				dp[i] = dp[i - 1] + 2;
				if(match > 0){
					dp[i] += dp[match - 1];// pay attention to ()(); this is also included in the line 9 condition
				}
				maxLen = Math.max(dp[i], maxLen);
			}

		}
		return maxLen;
	}
}