/*
	Solution: 1. Jump blank
			  2. Allow sign
			  3. 3 boolean
			  4. second sign
*/
public class Solution {
	public int isNumber(final String a) {
	    if(a == null || a.length() == 0) return 0;
	    int l = 0, r = a.length() - 1;
	    while(l <= r && Character.isWhitespace(a.charAt(l))) l++;
	    if(l > a.length() - 1) return 0;
	    while(l <= r && Character.isWhitespace(a.charAt(r))) r--;
	    if(a.charAt(l) == '+' || a.charAt(l) == '-') l++;
	    
	    boolean num = false;
	    boolean dot = false;
	    boolean exp = false;
	    
	    while(l <= r){
	        if(Character.isDigit(a.charAt(l))) num = true;
	        else if(a.charAt(l) == '.'){
	            if(exp || dot) return 0;
	            dot = true;
	            num = false;
	        } 
	        else if(a.charAt(l) == 'e'){
	            if(exp||!num) return 0;
	            exp = true;
	            num = false;
	        }
	        else if(a.charAt(l) == '+' || a.charAt(l) == '-'){
	            if(a.charAt(l - 1) != 'e') return 0;
	            num = false;
	        }
	        else return 0;
	        l++;
	    }
	    return num ? 1 : 0;
	}
}
