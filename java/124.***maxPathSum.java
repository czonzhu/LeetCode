/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }
    public int dfs(TreeNode root){
        if(root == null) return 0;
        int l = dfs(root.left);
        int r = dfs(root.right);
        int sum = root.val;
        if(l > 0) sum += l;
        if(r > 0) sum += r;
        max = Math.max(sum, max);
        return root.val + (Math.max(l, r) > 0 ? Math.max(l, r) : 0);
    }
}