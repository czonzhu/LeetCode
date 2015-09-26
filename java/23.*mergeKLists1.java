public class Solution{
	public ListNode mergeKLists(ListNode[] lists){
		if(lists == null || lists.length == 0) return null;
		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
			@Override
			public int compare(ListNode p1, ListNode p2){
				if(p1.val < p2.val) return -1;
				if(p2.val < p1.val) return 1;
				return 0;
			}
		});

		for(ListNode p : lists){
			if(p != null) queue.offer(p);
		}
		ListNode dummy = new ListNode(0);
		ListNode prev = dummy;
		while(!queue.isEmpty()){
			ListNode cur = queue.poll();
			prev.next = cur;
			prev = prev.next;
			if(cur.next != null) queue.offer(cur.next);// pay attention to that queue does not receive null list
		}
		return dummy.next;
	}
}