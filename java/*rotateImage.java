public class Solution {
	public void rotate(ArrayList<ArrayList<Integer>> a) {
	    int m = a.size(), n = a.get(0).size();
	    if(m == 0 || n == 0) return;
	    for(int i = 0; i < m / 2; i++){
	        for(int j = 0; j < n; j++){
	            int tmp = a.get(i).get(j);
	            a.get(i).set(j, a.get(m - 1 - i).get(j));
	            a.get(m - 1 - i).set(j, tmp);
	        }
	    }
	    
	    for(int i = 0; i < m; i++){
	        for(int j = i; j < n; j++){
	            int tmp = a.get(i).get(j);
	            a.get(i).set(j, a.get(j).get(i));
	            a.get(j).set(i, tmp);
	        }
	    }
	    return;
	    
	}
}
