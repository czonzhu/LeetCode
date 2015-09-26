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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> rst = new ArrayList<Integer>();
        if(root == null) return rst;
        traverse(root, rst);
        return rst;
    }
    public void traverse(TreeNode root, List<Integer> rst){
        if(root == null) return;
        traverse(root.left, rst);
        rst.add(root.val);
        traverse(root.right, rst);
    }
}