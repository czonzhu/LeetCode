public class Solution {
    public boolean verifyPreorder(int[] preorder){
    	if(preorder == null || preorder.length == 0) return true;
    	int low = Integer.MIN_VALUE;
    	Stack<Integer> stack = new Stack<>();
    	for(int p : preorder){
    		if(p < low) return false;
    	    while(!stack.empty() && stack.peek() < p)
    		low = stack.pop();
    	    stack.push(p);
	    }
    	return true;
    }
}