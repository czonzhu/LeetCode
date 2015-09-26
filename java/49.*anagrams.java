public class Solution{
	public List<String> anagrams(String[] strs){
		List<String> rst = new ArrayList<String>();
		if(strs == null || strs.length == 0) return rst;
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for(String str : strs){
			char[] tmp = str.toCharArray();
			Arrays.sort(tmp);
			String tmpstr = new String(tmp);
			if(!map.containsKey(tmpstr)){
				List<String> tmpList = new ArrayList<String>(Arrays.asList(str));
				map.put(tmpstr, tmpList);
			}
			else map.get(tmpstr).add(str);
		}
		for(String s : map.keySet()){
			if(map.get(s).size() != 1)
				rst.addAll(map.get(s));
		}
		return rst;
	}
}