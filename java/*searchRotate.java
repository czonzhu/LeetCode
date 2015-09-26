public class Solution {
	// DO NOT MODIFY THE LIST
	public int search(final List<Integer> a, int b) {
	    int l = 0, r = a.size() - 1;
	    while(l < r){
	        int mid = (l + r) / 2;
	        if(a.get(mid) == b) return mid;
	        if(a.get(l) <= a.get(mid)){
	            if(a.get(mid) > b && b >= a.get(l))
	                r = mid;
	            else l = mid + 1;
	        }
	        else{
	            if(a.get(mid) < b && b < a.get(l))
	                l = mid + 1;
	            else r = mid;
	        }
	    }
	    return -1;
	}
}
