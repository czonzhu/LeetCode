public class Solution{
	public RandomListNode copyRandomList(RandomListNode head){
		// 3 pass: one to construct copy node, one to construct random relation, one to take new list off
		if(head == null) return null;
		RandomListNode p = head;
		while(p != null){
			RandomListNode next = p.next;
			RandomListNode copy = new RandomListNode(p.label);
			p.next = copy;
			copy.next = next;
			p = next;
		}
		p = head;
		while(p != null){
			p.next.random = p.random != null ? p.random.next : null;
			p = p.next.next;
		}
		p = head;
		RandomListNode dummy = new RandomListNode(0);
		RandomListNode q = dummy;
		while(p != null){
			RandomListNode copy = p.next;
			q.next = copy;
			p.next = copy.next;
			p = p.next;
			q = q.next;
		}
		return dummy.next;
	}
}