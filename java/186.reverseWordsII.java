public class Solution{
	public void reverseWords(char[] s){
		// This traverse method of over 1 place can be found in maxGap
		if(s == null || s.length == 0) return;
		reverse(s, 0, s.length - 1);
		for(int i = 0, prev = 0; i <= s.length; i++){
			if(i == s.length || s[i] == ' '){
				reverse(s, prev, i - 1);
				prev = i + 1;
			}
		}
	}

	public void reverse(char[] s, int start, int end){
		while(start < end){
			char tmp = s[start];
			s[start] = s[end];
			s[end] = tmp;
			start++;
			end--;
		}
		return;
	}
}

/*
	public class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        if(s == null || s.length() == 0) return sb.toString();
        int j = s.length();
        for(int i = s.length() - 1; i >= 0; i--){
            if(s.charAt(i) == ' ') j = i;
            else if(i == 0 || s.charAt(i - 1) == ' '){
                if(sb.length() != 0) sb.append(" ");
                sb.append(s.substring(i, j));
            } 
        }
        return sb.toString();
    }
}
*/