public class Solution {
	public int isScramble(final String a, final String b) {
	    int len = a.length();
	    int dp[][][] = new int[len][len][len];//[i : i + k] [j: j + k]
	    for(int i = 0; i < len; i++){
	        for(int j = 0; j < len; j++){
	            if(a.charAt(i) == b.charAt(j))
	                dp[0][i][j] = 1; 
	        }
	    }
	    for(int l = 2; l <= len; l++){
	        for(int i = len - l; i >= 0; i--){
	            for(int j = len - l; j >= 0; j--){
	                for(int k = 1; k < l; k++)
	                   if((dp[k - 1][i][j] == 1 && dp[l - k - 1][i + k][j + k] == 1)||
	                   (dp[l - k - 1][i + k][j] == 1 && dp[k - 1][i][j + l - k] == 1)){
	                        dp[l - 1][i][j] = 1;
	                        break;
	                   }
	                
	            }
	            
	        }
	    }
	    return dp[len - 1][0][0];
	}
}
