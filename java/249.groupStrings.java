public class Solution{
	public List<List<String>> groupStrings(String[] strings){
		List<List<String>> rst = new ArrayList<List<String>>();
		if(strings == null || strings.length == 0) return rst;
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for(String str : strings){
			int offset = str.charAt(0) - 'a';
			String key = "";
			for(char c : str.toCharArray()){
				char tmpc = (char)(c - offset);
				if(tmpc < 'a') tmpc += 26;
				key += tmpc;
			}
			if(!map.containsKey(key)) map.put(key, new ArrayList<String>());
			map.get(key).add(str);
		}
		for(List<String> strs : map.values()){
			Collections.sort(strs);
			rst.add(strs);
		}
		return rst;
	}
}