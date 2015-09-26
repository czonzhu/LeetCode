public class Solution{
	public int lengthOfLastWord(String s){
		if(s == null || s.length() == 0) return 0;
		int j = s.length() - 1, count = 0;
		while(j >= 0 && s.charAt(j) == ' ') j--;// pay attention to the trailing spaces
		for(; j >=0 && s.charAt(j) != ' '; j--)pay attention to the j >= 0
			count++;
		return count;
	}
}