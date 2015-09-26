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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> rst = new ArrayList<Integer>();
        if(root == null) return rst;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.empty()){
            TreeNode cur = stack.pop();
            rst.add(0, cur.val); // preorder back.
            if(cur.left != null) stack.push(cur.left);
            if(cur.right != null) stack.push(cur.right);
        }
        return rst;
    }
}

/*
    Recursion://
    public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> rst = new ArrayList<Integer>();
        traverse(rst, root);
        return rst;
    }
    public void traverse(List<Integer> rst, TreeNode root){
        if(root == null) return;
        traverse(rst, root.left);
        traverse(rst, root.right);
        rst.add(root.val);
    }
}

*/