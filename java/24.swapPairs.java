public class Solution{
	public ListNode swapPairs(ListNode head){
		if(head == null) return null;
		if(head.next == null) return head;
		ListNode dummy = new ListNode(0);
		ListNode prev = dummy, cur = head, next = head.next;
		while(cur != null && next != null){
			prev.next = next;
			cur.next = next.next;
			next.next = cur;
			prev = prev.next.next;
			cur = prev.next;
			next = cur != null ? cur.next : null;
		}
		return dummy.next;
	}
}