public class Solution{
	public ListNode deleteDuplicates(ListNode head){
		if(head == null) return null;
		ListNode dummy = new ListNode(head.val - 1);
		dummy.next = head;
		ListNode prev = dummy;
		while(prev.next != null && prev.next.next != null){// take a trivial case to judge, take .next.next, caution for .next
			ListNode dup = prev.next;
			if(dup.val == dup.next.val){
				while(dup.next != null && dup.val == dup.next.val)//edge case caution.
					dup = dup.next;
				prev.next = dup.next;
			}
			else prev = dup;
		}
		return dummy.next;
	}
}