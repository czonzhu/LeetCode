public class Solution{
	public boolean isScramble(String s1, String s2){
		if((s1 == null || s1.length() == 0) && (s2 == null || s2.length() == 0)) return true;
		int len = s1.length();
		boolean dp[][][] = new boolean[len][len][len]; //[i + k] [j + k]
		for(int i = 0; i < len; i++){
			for(int j = 0; j < len; j++){
				dp[0][i][j] = s1.charAt(i) == s2.charAt(j);
			}
		}

		for(int l = 2; l <= len; l++){
			for(int i = len - l; i >= 0; i--){
				for(int j = len - l; j >= 0; j--){
					boolean r = false;
					for(int k = 1; k < l && r == false; k++){
						r = (dp[k - 1][i][j] && dp[l - k - 1][i + k][j + k]) || (dp[k - 1][i][j + l - k] && dp[l - k - 1][i + k][j]);
					}
					dp[l - 1][i][j] = r;
				}
			}
		}
		return dp[len - 1][0][0];
	}
}