public class Solution {
	public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> a) {
	    ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
	    ArrayList<Integer> path = new ArrayList<Integer>();
	    if(a == null) return rst; 
	    Collections.sort(a);
	    helper(rst, path, a, 0);
	    return rst;
	}
	
	public void helper(ArrayList<ArrayList<Integer>>rst, ArrayList<Integer> path, ArrayList<Integer> a, int pos){
	    
	     rst.add(new ArrayList<Integer>(path));
	    //int prev = Integer.MIN_VALUE;
	    for(int i = pos; i < a.size(); i++){
	        if(i != pos && a.get(i) == a.get(i - 1)) continue;
	        path.add(a.get(i));
	        helper(rst, path, a, i + 1);// this is not pos + 1
	        path.remove(path.size() - 1);
	        
	    }
	    
	}
}
