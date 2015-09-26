public class Solution{
	public void reorderList(ListNode head){
		 //1. find the middle 2. cut the list from the middle 3. reverse the back half 4. interleave the two lists
		if(head == null) return;
		ListNode slow = head, fast = head;
		while(fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode head2 = slow.next;
		slow.next = null;
		head2 = reverse(head2);
		ListNode p1 = head, p2 = head2, dummy = new ListNode(0), prev = dummy;
		while(p2 != null){// The interleaving part is trivial
			prev.next = p1;
			p1 = p1.next;
			prev = prev.next;
			prev.next = p2;
			p2 = p2.next;
			prev = prev.next;
		}
		prev.next = p1;
		dummy.next = null;
		return;
	}

	public ListNode reverse(ListNode head){
		ListNode newHead = null;
		while(head != null){
			ListNode tmp = head.next;
			head.next = newHead;
			newHead = head;
			head = tmp;
		}
		return newHead;
	}
}