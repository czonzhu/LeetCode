public class Solution{
	public void connect(TreeLinkNode root){
		// Take root as a dummy head
		while(root != null){
			TreeLinkNode p = root;
			while(p != null && p.left != null){// to the second last level
				p.left.next = p.right;
				p.right.next = p.next == null ? null : p.next.left;
				p = p.next;
			}
			root = root.left;
		}
	}
}