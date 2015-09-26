public class Solution {
    public int strStr(String haystack, String needle) {
      
        for(int i = 0; i + needle.length() <= haystack.length(); i++){// pay attention to the <=
            for(int j = 0; j <= needle.length(); j++){// let it jump 1 out of edge, two <=s!!!!!!!!!!
                if(j == needle.length()) return i;
                if(haystack.charAt(i + j) != needle.charAt(j)) break;// pay attention to the i + j
            }
        }
        return -1;
    }
}

/*
	public class Solution{
	public int[] pattern(String needle){
		int[] trace = new int[needle.length()];
		for(int i = 1, curIndex = 0; i < needle.length(); i++){
			while(curIndex != 0 && needle.charAt(curIndex) != needle.charAt(i)){
				curIndex = trace[curIndex - 1];// until we reduce to 0 or to a index that is equal to i
			}
			if(needle.charAt(curIndex) == needle.charAt(i)){
				curIndex++;
				trace[i] = curIndex;
			}
		}
		return trace;
	}
	public int strStr(String haystack, String needle){
		if(needle == null || needle.length() == 0) return 0;
		int[] trace = pattern(needle);
		for(int i = 0, curIndex = 0; i < haystack.length(); i++){
			while(curIndex != 0 && haystack.charAt(i) != needle.charAt(curIndex)){
				curIndex = trace[curIndex - 1];
			}
			if(haystack.charAt(i) == needle.charAt(curIndex)){
				curIndex++;
			}
			if(curIndex == needle.length()) return i - needle.length() + 1;
		}
		return -1;
	}
}
*/