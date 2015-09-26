/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
	public ListNode insertionSortList(ListNode a) {
	    if(a == null || a.next == null) return a;
	    ListNode dummy = new ListNode(Integer.MIN_VALUE);
	    ListNode prev;
	    ListNode p = a;
	    while(p != null){
	        prev = dummy;
	        while(prev.next != null && prev.next.val < p.val){
	            prev = prev.next;
	        }
	        ListNode tmp = p.next;
	        p.next = prev.next;
	        prev.next = p;
	     
	        p = tmp;
	    }
	    return dummy.next;
	}
}
