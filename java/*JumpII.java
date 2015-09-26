public class Solution {
	public int jump(ArrayList<Integer> a) {
	    if(a == null) return -1;
	    if(a.size() == 1) return 0;
	    int n = a.size();
	    
	    int count = 0;
	    int max = 0;
	    int start = 0, end = 0;
	    while(end < n - 1){
	        count++;
	        max = end;
	        for(int i = start; i <= end; i++){
	           
	            max = Math.max(max, a.get(i) + i);
	        }
	        if(max == end) return -1;
	        start = end + 1;
	        end = max;
	    }
	    return count;
	}
}
