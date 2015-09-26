public class Solution{
	public boolean isAnagram(String s, String t){
		if((s == null || s.length() == 0) && (t == null || t.length() == 0)) return true;
		if((s == null || s.length() == 0) || (t == null || t.length() == 0)) return false;
		if(s.length() != t.length()) return false;
		int[] map = new int[256];
		for(int i = 0; i < s.length(); i++) map[s.charAt(i)]++;
		for(int i = 0; i < t.length(); i++) map[t.charAt(i)]--;
		for(int i = 0; i < map.length; i++){
			if(map[i] != 0) return false;
		}
		return true;
	}
}

/*
	public class Solution {
    public List<String> anagrams(String[] strs) {
        List<String> rst = new ArrayList<String>();
        if(strs == null || strs.length == 0) return rst;
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for(String str : strs){
            char[] tmp = str.toCharArray();
            Arrays.sort(tmp);
            String keystr = new String(tmp);
            if(!map.containsKey(keystr)){
                List<String> tmpList = new ArrayList<String>(Arrays.asList(str));
                map.put(keystr, tmpList);
            }
            else{
                map.get(keystr).add(str);
            }
        }
        for(String s : map.keySet()){
            if(map.get(s).size() != 1)
                rst.addAll(map.get(s));
        }
        return rst;
    }
}
*/