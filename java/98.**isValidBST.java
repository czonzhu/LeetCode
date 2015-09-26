public class Solution{
	public boolean isValidBST(TreeNode root, long lower, long upper){
		if(root == null) return true;
		return root.val > lower && root.val < upper
		&& isValidBST(root.left, lower, root.val)
		&& isValidBST(root.right, root.val, upper);
	}

	public boolean isValidBST(TreeNode root){
		return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}
}