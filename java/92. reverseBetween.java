/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) return null;
        ListNode dummy = new ListNode(-1), prev = dummy, next = dummy;
        dummy.next = head;
        for(int i = 0; i < m - 1; i++) prev = prev.next;
        for(int i = 0; i < n + 1; i++) next = next.next;
        prev.next = reverse(prev.next, next);
        return dummy.next;
    }
    public ListNode reverse(ListNode prev, ListNode next){
        ListNode newHead = next;
        while(prev != next){
            ListNode tmp = prev.next;
            prev.next = newHead;
            newHead = prev;
            prev = tmp;
        }
        return newHead;
    }
}