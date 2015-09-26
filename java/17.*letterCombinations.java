public class Solution{
	public List<String> letterCombinations(String digits){
		List<String> rst = new ArrayList<String>();
		if(digits == null || digits.length() == 0) return rst;
		Map<Character, char[]> map = new HashMap<Character, char[]>(){{
			put('0', new char[]{});
            put('1', new char[] {});
            put('2', new char[] { 'a', 'b', 'c' });
            put('3', new char[] { 'd', 'e', 'f' });
            put('4', new char[] { 'g', 'h', 'i' });
            put('5', new char[] { 'j', 'k', 'l' });
            put('6', new char[] { 'm', 'n', 'o' });
            put('7', new char[] { 'p', 'q', 'r', 's' });
            put('8', new char[] { 't', 'u', 'v'});
            put('9', new char[] { 'w', 'x', 'y', 'z' });
		}};
		StringBuilder sb = new StringBuilder();
		helper(rst, sb, map, digits, 0);
		return rst;
	}

	public void helper(List<String> rst, StringBuilder sb, Map<Character, char[]> map, String digits, int pos){
		if(pos == digits.length()){
			rst.add(sb.toString());
			return;
		}
		for(char c : map.get(digits.charAt(pos))){
			sb.append(c);
			helper(rst, sb, map, digits, pos + 1);
			sb.deleteCharAt(sb.length() - 1);
		}
		return;
	}
}