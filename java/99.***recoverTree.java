public class Solution{
	TreeNode first = null, second = null, prev = new TreeNode(Integer.MIN_VALUE);
	public void recoverTree(TreeNode root){
		if(root == null) return;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;
		while(!stack.empty() || p != null){
			if(p != null){
				stack.push(p);
				p = p.left;
			}
			else{
				TreeNode tmp = stack.pop();
				if( tmp.val <= prev.val){
					if(first == null)
						first = prev;
					second = tmp;
				}
				p = tmp.right;
				prev = tmp;
			}
		}
		int tmp = first.val;
		first.val = second.val;
		second.val = tmp;
		return;
	}
}