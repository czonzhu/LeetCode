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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        helper(rst, root, 0);
        return rst;
    }
    public void helper(List<List<Integer>> rst, TreeNode root, int level){
        if(root == null) return;
        if(rst.size() <= level) rst.add(0, new ArrayList<Integer>());
        helper(rst, root.left, level + 1);
        helper(rst, root.right, level + 1);
        rst.get(rst.size() - 1 - level).add(root.val);
    }
}