public class Solution {
	public int maximalRectangle(ArrayList<ArrayList<Integer>> a) {
	    int m = a.size(), n = a.get(0).size();
	    if(m == 0 || n == 0) return 0;
	    int[] left = new int[n], right = new int[n], height = new int[n];
	    Arrays.fill(right, n);
	    int maxA = 0;
	    
	    for(int i = 0; i < m; i++){
	        int cur_left = 0, cur_right = n;
	        for(int j = 0; j < n; j++){
	            if(a.get(i).get(j) == 1) height[j]++;
	            else height[j] = 0;
	        }
	        for(int j = 0; j < n; j++){
	            if(a.get(i).get(j) == 1){
	                left[j] = Math.max(cur_left, left[j]);
	            }
	            else{
	                left[j] = 0;
	                cur_left = j + 1;
	            }
	        }
	        for(int j = n - 1; j >= 0; j--){
	            if(a.get(i).get(j) == 1){
	                right[j] = Math.min(cur_right, right[j]);
	            }
	            else{
	                right[j] = n;
	                cur_right = j;
	            }
	        }
	        for(int j = 0; j < n; j++){
	            maxA = Math.max(maxA,( right[j] - left[j]) * height[j]);
	        }
	      
	    }
	      return maxA;
	}
}
