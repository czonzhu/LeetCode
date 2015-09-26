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
    public int kthSmallest(TreeNode root, int k) {
        	int count = 0;
			if(root == null) return -1;
			Stack<TreeNode> stack = new Stack<TreeNode>();
			TreeNode p = root;
			while(!stack.empty() || p != null){
			    if(p != null){
			        stack.push(p);
			        p = p.left;
			    }
			    else{
			        TreeNode cur = stack.pop();
			        count++;
			        if(count == k) return cur.val;
			        p = cur.right;
			    }
			}
			return -1;
    }
}