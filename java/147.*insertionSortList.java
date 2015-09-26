public class Solution{
	// 开窍
	public ListNode insertionSortList(ListNode head){
		if(head == null) return null;
		ListNode dummy = new ListNode(0); // Used to construct a new list.
		while(head != null){
			ListNode prev = dummy;
			while(prev.next != null && prev.next.val < head.val) prev = prev.next;// insert to the right position of the new Node
			ListNode tmp = head.next;
			head.next = prev.next;
			prev.next = head;
			head = tmp;
		}
		return dummy.next;
	}
}