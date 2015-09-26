/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    // Tricky, make a circle list first, only use one pointer.
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        ListNode p1 = head;
        int len = 1;
        while(p1.next != null){
            p1 = p1.next;
            len++;
        }
        k = len - k % len;
        p1.next = head;
        for(int i = 0; i < k; i++)
            p1 = p1.next;
        ListNode tmp = p1.next;
        p1.next = null;
        return tmp;
    }
}