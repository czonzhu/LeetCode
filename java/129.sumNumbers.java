public class Solution{
	public int sumNumbers(TreeNode root){
		// TopDown approach: 带着上层顺下来的值一路深搜下去
		return dfs(root, 0);
	}
	public int dfs(TreeNode root, int prev){
		if(root == null) return 0;
		int sum = prev * 10 + root.val;
		if(root.left == null && root.right == null) return sum;
		return dfs(root.left, sum) + dfs(root.right, sum);
	}
}