public class Solution{
	public int lengthOfLongestSubstringTwoDistinct(String s){
		// extent right bound and shrink left bound, update the map.
		if(s == null || s.length() == 0) return 0;
		int[] count = new int[256];
		int l = 0, numDistinct = 0, maxLen = 0;
		for(int r = 0; r < s.length(); r++){
			if(count[s.charAt(r)] == 0) numDistinct++;
			count[s.charAt(r)]++;
			while(numDistinct > 2){
				count[s.charAt(l)]--;
				if(count[s.charAt(l)] == 0) numDistinct--;
				l++;
			}
			maxLen = Math.max(maxLen, r - l + 1);
		}
		return maxLen;
	}
}

/*
	public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null || s.length() == 0) return 0;
        char[] map = new char[256];
        int maxLen = 0, numDistinct = 0, l = 0;
        for(int r = 0; r < s.length(); r++){
               if(map[s.charAt(r)]++ == 0) numDistinct++;
               while(numDistinct > 2){
                   if(--map[s.charAt(l)] == 0) numDistinct--;
                   l++;
               }
               maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }
}

*/