/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k < 2) return head;
        ListNode dummy = new ListNode(0), end = head;
        dummy.next = head;
        ListNode prev = dummy;
        while(end != null){
            for(int i = 1; i < k && end != null; i++){
                end = end.next;
            }
            if(end == null) return dummy.next;
            ListNode start = prev.next;
            prev.next = reverse(prev.next, end);
            prev = start;
            end = prev.next;
        }
        return dummy.next;
     }
     public ListNode reverse(ListNode head, ListNode end){
         ListNode end_Next = end.next, newHead = end_Next;
         while(head != end_Next){
             ListNode tmp = head.next;
             head.next = newHead;
             newHead = head;
             head = tmp;
         }
         return newHead;
     }
}