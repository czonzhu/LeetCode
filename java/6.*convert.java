public class Solution{
	public String convert(String s, int numRows){
		StringBuilder[] sb = new StringBuilder[numRows];
		for(int i = 0; i < numRows; i++) sb[i] = new StringBuilder();//pay attention to the initialization of the sb.
		int j = 0;
		while(j < s.length()){
			for(int i = 0; i < numRows && j < s.length(); i++)//caution: j < s.length()
				sb[i].append(s.charAt(j++));
			for(int i = numRows - 2; i > 0 && j < s.length(); i--)
				sb[i].append(s.charAt(j++));
		}
		for(int i = 1; i < numRows; i++)
			sb[0].append(sb[i]);
		return sb[0].toString();
	}
}