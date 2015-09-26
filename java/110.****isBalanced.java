public class Solution {
	//Bottom up: recursive first then manipulate
    public boolean isBalanced(TreeNode root) {
        return helper(root) >= 0;
    }
    public int helper(TreeNode root){//The depth of a tree and -1 if anything wront
    	if(root == null) return 0;
    	int left = helper(root.left);
    	if(left == -1) return -1;
    	int right = helper(root.right);
    	if(right == -1) return -1;
    	if(Math.abs(right - left) > 1) return -1;
    	return Math.max(right, left) + 1;
    }
}