public class Solution {
	public ArrayList<String> fullJustify(ArrayList<String> a, int b) {
	    ArrayList<String> rst = new ArrayList<String>();
	    
	    for(int i = 0, w; i < a.size(); i = w){
	        int len = -1;
	        for(w = i; w < a.size() && len + a.get(w).length() < b; w++){
	            len += a.get(w).length() + 1;
	        }
	        
	        StringBuilder sb = new StringBuilder(a.get(i));
	        int space = 1, extra = 0;
	        if(w != i + 1 && w != a.size()){
	            space = (b - len)/(w - i - 1) + 1;
	            extra = (b - len) % (w - i - 1);
	        }
	        
	        for(int j = i + 1; j < w; j++){
	            for(int s = 0; s < space; s++) sb.append(" ");
	            if(extra-- > 0) sb.append(" ");
	            sb.append(a.get(j));
	        }
	        int strlen = b - sb.length();
	        while(strlen-- > 0) sb.append(" ");
	        rst.add(sb.toString());
	    }
	    return rst;
	}
}
