public class Solution{
	public boolean isPalindrome(ListNode head){
		if(head == null || head.next == null)
			return true;
		ListNode slow = head, fast = head;
		while(fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		slow.next = reverse(slow.next);
		slow = slow.next;
		while(slow != null){
			if(head.val != slow.val) return false;
			head = head.next;
			slow = slow.next;
		}
		return true;
	}

	private ListNode reverse(ListNode head){
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