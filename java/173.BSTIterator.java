public class BSTIterator{
	private Stack<TreeNode> stack = new Stack<TreeNode>();
	public BSTIterator(TreeNode root){
		pushAll(root);
	}

	public boolean hasNext(){
		return !stack.empty();
	}
	public int next(){
		TreeNode cur = stack.pop();
		pushAll(cur.right);
		return cur.val;
	}

	private void pushAll(TreeNode node){
		TreeNode p = node;
		while(p != null){
			stack.push(p);
			p = p.left;
		}
		return;
	}
}