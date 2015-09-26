/*
	Solution: 1. count the number of dots and ending condition
			  2. use stringbuilder as the path
*/
public class Solution {
	public ArrayList<String> restoreIpAddresses(String a) {
	    ArrayList<String> rst = new ArrayList<String>();
	    int len = a.length();
	    if(len < 4 || len > 12) return rst;
	    StringBuilder path = new StringBuilder();
	    helper(rst, path, a, 0, 0);
	    return rst;
	}
	
	public void helper(ArrayList<String> rst, StringBuilder path,  String a, int pos, int dots){
	    if(pos == a.length() && dots == 4){
	        rst.add(path.substring(0, path.length() - 1));
	        return;
	    }
	    if(dots == 4) return;
	    for(int i = pos + 1; i <= Math.min(pos + 4, a.length()); i++){// Like the buffer problem
	        String sub = a.substring(pos, i);
	        int val = getVal(sub);
	        if(val != -1 && val <= 255){
	            path.append(a.substring(pos, i));
	            path.append('.');
	            helper(rst, path, a, i, dots + 1);
	            path.delete(path.length() - sub.length() - 1, path.length());
	        }
	    }
	}
	public int getVal(String str){
	    if(str.length() > 1 && str.charAt(0) == '0') return -1;
	    return Integer.valueOf(str);// Pay attention to this function.
	}
}
