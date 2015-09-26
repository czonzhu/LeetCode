public class Solution {
	public String reverseWords(String a) {
	    if(a == null || a.length() == 0) return "";
	    String[] stringArray = a.split(" ");
	    String rst = "";
	    for(String s : stringArray){
	        if(!s.equals("")){
	            rst = s + " " + rst; 
	        }
	    }
	    return rst.substring(0, rst.length() - 1);
	    
	}
}
