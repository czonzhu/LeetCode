/*
	Solution: BackTraceDP
*/
public class Solution {
	public int wordBreak(String a, ArrayList<String> b) {
	    HashSet<String> dict = new HashSet<String>();
	    for(String str : b)
	        dict.add(str);
	        
	    boolean[] f = new boolean[a.length() + 1];
	    f[0] = true;
	    for(int i = 1; i <= a.length(); i++){
	        for(int j = i - 1; j >= 0; j--){
	            if(f[j] == true && b.contains(a.substring(j, i)))
	            {     f[i] = true;
	                  break;
	            }
	               
	        }
	    }
	    
	    
	    return f[a.length()] ? 1 : 0;
	}
}
