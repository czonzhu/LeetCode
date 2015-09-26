public class Solution{
	public List<Integer> rightSideView(TreeNode root){
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		List<Integer> rst = new ArrayList<Integer>();
		if(root == null) return rst;
		queue.offer(root);
		while(!queue.isEmpty()){
			int size = queue.size();
			for(int i = 0; i < size; i++){
				TreeNode cur = queue.poll();
				if(i == size - 1) rst.add(cur.val);
				if(cur.left != null) queue.offer(cur.left);
				if(cur.right != null) queue.offer(cur.right);
			}
		}
		return rst;
	}
}