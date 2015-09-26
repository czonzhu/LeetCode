public class Solution{
	public List<Integer> findSubstring(String s, String[] words){
		List<Integer> rst = new ArrayList<Integer>();
		if(s == null || s.length() == 0 || words == null || words.length == 0)
			return rst;
		HashMap<String, Integer> toFind = new HashMap<String, Integer>();
		HashMap<String, Integer> found = new HashMap<String, Integer>();
		for(String str : words)
			toFind.put(str, toFind.containsKey(str) ? toFind.get(str) + 1 : 1);
		int m = words.length, n = words[0].length();
		for(int i = 0; i + m * n <= s.length(); i++){// pay attention to  i + m * n
			found.clear();
			for(int j = 0; j < m; j++){
				String word = s.substring(i + j * n, i + (j + 1) * n);// pay attention to the substring (i + j * n, i + (j + 1) * n)
				if(!toFind.containsKey(word)) break;
				found.put(word, found.containsKey(word) ? found.get(word) + 1 : 1);
			}
			if(found.equals(toFind)) rst.add(i);
		}
		return rst;
	}
}