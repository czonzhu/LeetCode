/*
	Solution: BackTraceDP
*/
public class Solution {
	public ArrayList<String> wordBreak(String a, ArrayList<String> b) {
	    ArrayList<String> rst = new ArrayList<String>();
	    HashSet<String> set = new HashSet<String>();
	    for(String str : b){
	        set.add(str);
	    }
	    //edge case
	    for(int j = a.length() - 1; j >= 0; j--){
	        if(set.contains(a.substring(j))) break;
	        else if(j == 0) return rst;
	    }
	    
	    for(int i = 0; i < a.length() - 1; i++){
	        if(b.contains(a.substring(0, i + 1))){
	            ArrayList<String> list = new ArrayList<String>();
	            list = wordBreak(a.substring(i + 1, a.length()), b);
	            if(list.size() != 0){
	                for(String tmp : list){
	                    rst.add(a.substring(0, i + 1)+ " " +tmp);
	                }
	            }
	        }
	    }
	    if(set.contains(a)) rst.add(a);
	    return rst;
	   
	}
}
