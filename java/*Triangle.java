public class Solution {
	public int minimumTotal(ArrayList<ArrayList<Integer>> a) {
	    if(a == null) return 0;
	    for(int i = a.size() - 2; i >= 0; i--){
	        for(int j = 0; j <= i; j++){
	            a.get(i).set(j, Math.min(a.get(i + 1).get(j), a.get(i + 1).get(j + 1)) + a.get(i).get(j));
	        }
	    }
	    return a.get(0).get(0);
	}
}
