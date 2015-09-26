public class Solution{
	public ListNode partition(ListNode head, int x){
		if(head == null) return null;
		ListNode dummy1 = new ListNode(-1), dummy2 = new ListNode(-1),
		prev1 = dummy1, prev2 = dummy2;
		ListNode p = head;
		while(p != null){
			if(p.val < x){
				prev1.next = p;
				prev1 = prev1.next;
			}
			else{
				prev2.next = p;
				prev2 = prev2.next;
			}

			p = p.next;
		}
		prev1.next = dummy2.next;
		prev2.next = null;// Get rid of the previous relationship !!!!!!!!!!!!
		return dummy1.next;
	}
}