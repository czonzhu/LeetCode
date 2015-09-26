public class Solution {
	public int numDistinct(String S, String T) {
	    int ls = S.length(), lt = T.length();
	    if(lt > ls) return 0;
	    int[][] f = new int[ls + 1][lt + 1];
	    
	    for(int i = 0; i <= ls; i++){
	        f[i][0] = 1;
	    }
	    
	    for(int i = 1; i <= ls; i++){
	        for(int j = 1; j <= lt; j++){
	            f[i][j] = f[i - 1][j] + ((S.charAt(i - 1) == T.charAt(j - 1)) ? f[i - 1][j - 1] : 0);
	        }
	    }
	    return f[ls][lt];
	}
}
