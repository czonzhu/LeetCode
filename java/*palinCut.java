public class Solution {
	public int minCut(String a) {
	    if(a == null || a.length() == 0) return 0;
	    int n = a.length();
	    char[] charA = a.toCharArray();
	    int[] cut = new int[n + 1];
	    for(int i = 0; i <= n; i++){
	        cut[i] = i - 1;
	    }
	    for(int i = 0; i < a.length(); i++){
	        for(int j = 0; i - j >= 0 && i + j < n && charA[i - j] == charA[i + j]; j++){
	            cut[i + j + 1] = Math.min(cut[i + j + 1], 1 + cut[i - j]);
	        }
	        for(int j = 1; i - j + 1 >= 0 && i + j < n && charA[i - j + 1] == charA[i + j]; j++){
	            cut[i + j + 1] = Math.min(cut[i + j + 1], 1 + cut[i - j + 1]);
	        }
	    }
	    return cut[n];
	}

}
