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
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        TreeNode p = root;
        while(!stack.empty() || p != null){// ||
            if(p != null){
                stack.push(p);
                p = p.left;
            }else{
                TreeNode t = stack.pop();
                rst.add(t.val);
                p = t.right;
            }
        }
        return rst;
    }
}