public class Solution{
	public String reverseWords(String s){
		// Two Pointers.
		StringBuilder rst = new StringBuilder();
		if(s == null || s.length() == 0) return rst.toString();
		int j = s.length();
		for(int i = s.length() - 1; i >= 0; i--){
			if(s.charAt(i) == ' ') j = i;
			else if(i == 0 || s.charAt(i - 1) == ' '){
				if(rst.length() != 0) rst.append(" ");// A very important condition.
				rst.append(s.substring(i, j));
			}
		}
		return rst.toString();
	}
}

/*
	public String reverseWords(String s){
		StringBuilder rst = new StringBuilder();
		if(s == null || s.length() == 0) return rst.toString();
		String[] strs = s.trim().split("\\s+ ");// newly learned API
		if(strs.length == 0) return rst.toString();
		for(int i = strs.length - 1; i >= 1; i--){
			rst.append(strs[i] + " ");
		}
		rst.append(strs[0]);
		return rst.toString();
	}
*/