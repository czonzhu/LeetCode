public class Solution{
	public TreeNode upsideDownBinaryTree(TreeNode root){
		TreeNode p = root, parent = null, parentRight = null;
		while(p != null){
			TreeNode tmp = p.left;
			p.left = parentRight;
			parentRight = p.right;
			p.right = parent;
			parent = p;
			p = tmp;
		}
		return parent;
	}
}

/*
	public ListNode reverse(head){
		ListNode newHead = null;
		while(head != null){
			ListNode tmp = head.next;
			head.next = newHead;
			newHead = head;
			head = tmp;
		}
		return newHead;
	}
*/