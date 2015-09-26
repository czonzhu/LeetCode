public class Solution{
	public boolean isMatch(String s, String p){
		int lens = s.length(), lenp = p.length();
		boolean[][] dp = new boolean[lens + 1][lenp + 1];

		for(int i = 0; i <= lens; i++){
			for(int j = 0; j <= lenp; j++){
				if(j == 0) dp[i][j] = (i == 0);
				else if(i == 0){
					if(j > 1 && p.charAt(j - 1) == '*')
						dp[i][j] = dp[i][j - 1]||dp[i][j - 2];
				}
				else{//1. parallel 2. * reduce 3. * more
					char sc = s.charAt(i - 1);
					char pc = p.charAt(j - 1);
					if(sc == pc || pc == '.'){
						dp[i][j] = dp[i - 1][j - 1];
					}
					else if(j > 1 && pc == '*'){
						if((sc == p.charAt(j - 2) || p.charAt(j - 2) == '.') && dp[i - 1][j]){// caution, cant write dp[i][j] = dp[i - 1][j]
							dp[i][j] = true;
						}
						else dp[i][j] = dp[i][j - 1] || dp[i][j - 2];
					}
				}
			}
		}
		return dp[lens][lenp];
	}
}