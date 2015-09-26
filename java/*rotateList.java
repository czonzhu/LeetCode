/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
	public ListNode rotateRight(ListNode a, int b) {
	    if(a == null || b == 0) return a;
	    
	    ListNode p = a;
	    int count = 1;
	    while(p.next != null){
	        p = p.next;
	        count++;
	    }
	    
	    b = count - b % count;
	    
	    ListNode dummy = new ListNode(0);
	    dummy.next = a;
	    ListNode p2 = dummy;
	    
	    p.next = a;// Where it could be clean
	    for(int i = 0; i < b; i++){
	        p2 = p2.next;
	    }
	    
	    a = p2.next;
	    p2.next = null;
	    
	    
	    return a;
	}
}
