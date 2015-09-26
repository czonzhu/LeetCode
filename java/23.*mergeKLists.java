public class Solution{
	// Divide and conquer O(nklgk)
	public ListNode mergeKLists(ListNode[] lists){
		if(lists == null || lists.length == 0) return null;
		int end = lists.length - 1;
		while(end > 0){
			int begin = 0;
			while(begin < end){
				lists[begin] = mergeTwo(lists[begin], lists[end]);
				begin++;
				end--;
			}
		}
		return lists[0];
	}

	public ListNode mergeTwo(ListNode p1, ListNode p2){
		if(p1 == null && p2 == null) return null;
		if(p1 == null) return p2;
		if(p2 == null) return p1;
		ListNode dummy = new ListNode(0);
		ListNode prev = dummy;
		while(p1 != null && p2 != null){
			if(p1.val < p2.val){
				prev.next = p1;
				p1 = p1.next;
			}
			else{
				prev.next = p2;
				p2 = p2.next;
			}
			prev = prev.next;
		}
		prev.next = p1 != null ? p1 : p2;
		return dummy.next;
	}
}