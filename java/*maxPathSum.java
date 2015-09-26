/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 // Note down the sum path during every dfs process
public class Solution {
    int maxSum = Integer.MIN_VALUE;
	public int maxPathSum(TreeNode a) {
	    
	    dfs(a);
	    return maxSum;
	   
	}
	public int dfs(TreeNode a){
	    if(a == null) return 0;
	    int l = dfs(a.left);
	    int r = dfs(a.right);
	    int sum = a.val;
	    if(l > 0) sum += l;
	    if(r > 0) sum += r;
	    maxSum = Math.max(maxSum, sum);
	    return (l > 0) || (r > 0) ? Math.max(l , r) + a.val : a.val;
	}
}
