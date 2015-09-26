/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    // Dont count it wrong, easy and also easy to make mistake
    // Extention: what if the linkedlist is a circle list, how to find the head and tail.

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode s = dummy, f = dummy;
        for(int i = 0; i < n; i++){
            f = f.next;
        }
        while(f.next != null){
            f = f.next;
            s = s.next;
        }
        s.next = s.next.next;
        return dummy.next;
    }
}