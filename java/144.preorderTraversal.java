public class Solution{
	public List<Integer> preorderTraversal(TreeNode root){
		List<Integer> rst = new ArrayList<Integer>();
		if(root == null) return rst;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while(!stack.empty()){
			TreeNode tmp = stack.pop();
			rst.add(tmp.val);
			if(tmp.right != null) stack.push(tmp.right);
			if(tmp.left != null) stack.push(tmp.left);
		}
		return rst;
	}
}
/*
Recursion:
public class Solution{
	public List<Integer> preorderTraversal(TreeNode root){
		List<Integer> rst = new ArrayList<Integer>();
		traverse(rst, root);
		return rst;
	}
	public void traverse(List<Integer> rst, TreeNode root){
	    if(root == null) return;
	    rst.add(root.val);
	    traverse(rst, root.left);// 一搜到底
	    traverse(rst, root.right);
	}
}
*/
/*
	Inorder traversal:
	public class Solution{
		public List<Integer> inorderTraversal(TreeNode root){
			List<Integer> rst = new ArrayList<Integer>();
			if(root == null) return rst;
			Stack<TreeNode> stack = new Stack<TreeNode>();
			TreeNode p = root;
			while(!stack.empty() || p != null){
				if(p != null){
					stack.push(p);
					p = p.left;
				}
				else{
					TreeNode cur = stack.pop();
					rst.add(cur.val);
					p = cur.right;
				}
			}
			return rst;
		}
	}



*/