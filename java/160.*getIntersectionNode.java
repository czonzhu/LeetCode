public class Solution{
	public ListNode getIntersectionNode(ListNode headA, ListNode headB){
		if(headA == null || headB == null) return null;
		ListNode p1 = headA, p2 = headB;
		while(p1 != p2){
			if(p1.next == null && p2.next == null) return null;
			p1 = p1.next != null ? p1.next : headB;
			p2 = p2.next != null ? p2.next : headA;
		}
		return p1;
	}
}