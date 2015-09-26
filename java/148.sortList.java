public class Solution{
	public ListNode sortList(ListNode head){
		// 分治或递归一定要注意终止条件
		if(head == null || head.next == null) return head;// ending condition
		ListNode slow = head, fast = head;
		while(fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode head2 = slow.next;
		slow.next = null;
		head = sortList(head);
		head2 = sortList(head2);
		return merge(head, head2);
	}
	public ListNode merge(ListNode head1, ListNode head2){}
		ListNode dummy = new ListNode(0), p = dummy;
		while(head2 != null && head1 != null){
			if(head1.val < head2.val){
				p.next = head1;
				head1 = head1.next;
			}
			else{
				p.next = head2;
				head2 = head2.next;
			}
			p = p.next;
		}
		p.next = head1 != null ? head1 : head2;
		return dummy.next;
	}

}
/*
Related:
public class Solution{
	// traversal 的方式很奇妙
	private ListNode head;
	public TreeNode sortedListToBST(ListNode head){
		if(head == null) return null;
		ListNode p = head;
		int count = 1;
		while(p.next != null){
			p = p.next;
			count++;
		}
		this.head = head;
		return helper(0, count - 1);
	}

	TreeNode helper(int start, int end){
		if(start > end) return null;
		int mid = start + (end - start) / 2;
		TreeNode left = helper(start, mid - 1);
		TreeNode root = new TreeNode(head.val);
		head = head.next;
		TreeNode right = helper(mid + 1, end);
		root.left = left;
		root.right = right;
		return root;
	}
}


*/