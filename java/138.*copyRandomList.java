public class Solution{
	public RandomListNode copyRandomList(RandomListNode head){
		// Related: clone Graph. 1. Use a hashMap 2. traverse it. add to the relation list
		// Two pass, one for construct new node, one for construct random relation
		if(head == null) return null;
		RandomListNode dummy = new RandomListNode(0);
		RandomListNode q = dummy;
		RandomListNode p = head;
		HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		while(p != null){
			q.next = new RandomListNode(p.label);
			map.put(p, q.next);
			p = p.next;
			q = q.next;
		}
		p = head;
		q = dummy;
		while(p != null){
			q.next.random = map.get(p.random);
			p = p.next;
			q = q.next;
		}
		return dummy.next;
	}
}