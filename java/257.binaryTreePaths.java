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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> rst = new ArrayList<String>();
        if(root == null) return rst;
        StringBuilder sb = new StringBuilder();
        helper(rst, sb, root);
        return rst;
    }
    
    public void helper(List<String> rst, StringBuilder sb, TreeNode root){
        if(root == null) return;
        if(root.left == null && root.right == null){
            sb.append(root.val);
            rst.add(sb.toString());
            sb.deleteCharAt(sb.length() - 1);
            return;
        }
        int tmp = sb.length();
        sb.append(root.val + "->");
        helper(rst, sb, root.left);
        sb.delete(tmp , sb.length());
        sb.append(root.val + "->");
        helper(rst, sb, root.right);
        sb.delete(tmp , sb.length());
        return;
        
    }
}