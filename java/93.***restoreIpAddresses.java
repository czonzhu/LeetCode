public class Solution{
	public List<String> restoreIpAddresses(String s){
		List<String> rst = new ArrayList<String>();
		if(s == null || s.length() < 4 || s.length() > 12) return rst;
		StringBuilder path = new StringBuilder();
		helper(rst, path, s, 0, 0);
		return rst;
	}
	public void helper(List<String> rst, StringBuilder path, String s, int dots, int pos){
		if(dots == 4 && pos >= s.length()){
			rst.add(path.substring(0, path.length() - 1));
			return;
		}
		if(dots == 4) return;
		for(int i = pos; i < Math.min(s.length(), pos + 3); i++){
			String tmp = s.substring(pos, i + 1);
			if(tmp.length() > 1 && tmp.charAt(0) == '0') return;
			if(Integer.valueOf(tmp) <= 255){
				path.append(tmp);
				path.append('.');
				helper(rst, path, s, dots + 1, i + 1);
				path.delete(path.length() - tmp.length() - 1, path.length());
			}

		}
		
	}
}