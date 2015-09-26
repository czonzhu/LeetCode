public class Solution {
	public String countAndSay(int a) {
	    String rst = "1";
	    for(int i = 0; i < a - 1; i++)
	         rst = helper(rst);
	    return rst;
	   
	    
	}
	public String helper(String num){
	    String rst = "";
	    
	    int i = 0;
	    
	    while(i < num.length()){
	        Character digit = num.charAt(i);
            int count = 1;
	        while(i != num.length() - 1 && num.charAt(i) == num.charAt(i + 1)){
	            count++;
	            i++;
	        }
	        rst = rst + String.valueOf(count) + String.valueOf(digit) ;
	        
	        i++;
	    }
	    return rst;
	}
}
