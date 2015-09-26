public class Codec{
	public String encode(List<String> strs){
		StringBuilder sb = new StringBuilder();
		for(String s : strs){
			sb.append(s.length()).append('/').append(s);
		}
		return sb.toString();
	}

	public List<String> decode(String s){
	    List<String> rst = new ArrayList<String>();
		int i = 0;
		while(i < s.length()){
			int slash = s.indexOf('/', i);
			int size = Integer.valueOf(s.substring(i, slash));
			rst.add(s.substring(slash + 1, slash + size + 1));
			i = slash + size + 1;
		}
		return rst;
	}
}