public class Solution{
	public TreeNode sortedArrayToBST(int[] num){
		if(num == null || num.length == 0) return null;
		return helper(num, 0, num.length - 1);
	}
	public TreeNode helper(int[] num, int start, int end){
		if(start > end) return null;
		int mid = (start + end) / 2;
		TreeNode root = new TreeNode(num[mid]);
		TreeNode left = helper(num, start, mid - 1);
		TreeNode right = helper(num, mid + 1, end);
		root.left = left;
		root.right = right;
		return root;
	}
}