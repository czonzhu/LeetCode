/*
	Problem: return the longets substring without dup character
	Solution: use the hashMap to record the position of each character
	Caution: j will never go back: j = Math.max(j, map.get(s.charAt(i)))
			 map should be updated all the time.
*/
public class Solution{
	public int lengthOfLongestSubstring(String s){
		if(s == null) return 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int rst = 0;
		for(int i = 0, j = 0; i < s.length(); i++){
			if(map.containsKey(s.charAt(i)))
				j = Math.max(j, map.get(s.charAt(i)))
			map.put(s.charAt(i), i);
			rst = Math.max(rst, i - j + 1);
		}
		return rst;
	}
}