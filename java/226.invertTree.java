public class Solution{
	public TreeNode invertTree(TreeNode root){
		if(root == null) return null;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while(!stack.empty()){
			TreeNode cur = stack.pop();
			TreeNode tmp = cur.right;
			cur.right = cur.left;
			cur.left = tmp;
			if(cur.left != null) stack.push(cur.left);
			if(cur.right != null) stack.push(cur.right);
		}
		return root;
	}
}