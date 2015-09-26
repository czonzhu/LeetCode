/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        TreeNode pre = null;
        while(!stack.empty() || p != null){
            if(p != null){
                stack.push(p);
                p = p.left;
            } else {
                TreeNode t = stack.pop();
                if(pre != null && t.val <= pre.val) return false;// Area of do sth.
                pre = t;
                p = t.right;
            }
        }
        return true;
    }
}