public class Solution {
	public int lengthOfLongestSubstring(String a) {
	    if(a == "" || a.length() == 0) return 0;
        int rst = 0;
	    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	    for(int i = 0, j = 0; i < a.length(); i++){
	        if(map.containsKey(a.charAt(i))){
	            j = Math.max(map.get(a.charAt(i)) + 1, j);
	        }
	        map.put(a.charAt(i), i);
	        rst = Math.max(i - j + 1, rst);
	    }
	    return rst;
	}
}
