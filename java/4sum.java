public class Solution {
	public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> a, int b) {
	    ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
	    if(a.size() < 4) return rst;
	    Collections.sort(a);
	       
	    
	    for(int left = 0; left < a.size() - 3; left++){
	        if(left > 0 && a.get(left) == a.get(left - 1)) continue;
	        for(int right = a.size() - 1; right >= left + 3; right--){
    	        if(right < a.size() - 1 && a.get(right) == a.get(right + 1)) continue;
    	        int sum1 = a.get(left) + a.get(right);
    	        int sum2 = b - sum1;
    	        int l = left + 1, r = right - 1;
    	        while(l < r){
    	            if(l > left + 1 && a.get(l) == a.get(l - 1)) {
    	                l++;
    	                continue;
    	            }
    	            if(r < right - 1 && a.get(r) == a.get(r + 1)){
    	                r--;
    	                continue;
    	            }
    	            if(a.get(l) + a.get(r) == sum2){
    	                ArrayList<Integer> path = new ArrayList<Integer>();
    	                path.add(a.get(left));
    	                path.add(a.get(l));
    	                path.add(a.get(r));
    	                path.add(a.get(right));
    	                rst.add(path);
    	                l++;
    	                r--;
    	            }
    	            else if(a.get(l) + a.get(r) < sum2){
    	                l++;
    	            }
    	            else r--;
    	        }
	        }
	    }
	    return rst;
	}
}
/*

public class Solution {
	public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> a, int b) {
	    ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
	    if(a.size() < 4) return rst;
	    Collections.sort(a);
	       
	    
	   for(int left = 0; left < a.size() - 3; left++){
	       if(left > 0 && a.get(left - 1) == a.get(left)) continue;
	       for(int left2 = left + 1; left2 < a.size() - 2; left2++){
	           if(left2 > left + 1 && a.get(left2 - 1) == a.get(left2)) continue;
	           int l = left2 + 1, r = a.size() - 1;
	           int sum = b - a.get(left) - a.get(left2); 
	           while(l < r){
	               if(l > left2 + 1 && a.get(l) == a.get(l - 1)){
	                   l++;
	                   continue;
	               }
	               if(r < a.size() - 2 && a.get(r) == a.get(r + 1)){
	                   r--;
	                   continue;
	               }
	               if(a.get(l) + a.get(r) == sum){
	                   ArrayList<Integer> tmp = new ArrayList<Integer>(Arrays.asList(
	                       a.get(left), a.get(left2), a.get(l++), a.get(r--)));
	                   rst.add(tmp);
	                   
	               }
	               else if(a.get(l) + a.get(r) < sum) l++;
	               else r--;
	           }
	       }
	       
	   }
	   return rst;
	}

}


*/
