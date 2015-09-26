/*
    Problem: add two linked list;
    Solution: 
            1. Set pointers
            2. Set values and sum and carry
            3. traverse
            4. add carry
    Caution: 1. Don't forget to traverse
            2. Don't forget to return
*/
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p1 = l1, p2 = l2, p = dummy;
        int carry = 0;
        while(p1 != null || p2 != null){
            int val1 = p1 != null ? p1.val : 0;
            int val2 = p2 != null ? p2.val : 0;
            int sum = val1 + val2 + carry;
            int val = sum % 10;
            carry = sum / 10;
            p.next = new ListNode(val);
            p = p.next;
            p1 = p1 != null ? p1.next : null;
            p2 = p2 != null ? p2.next : null;
        }
        if(carry != 0) p.next = new ListNode(carry);
        return dummy.next;
    }
}

/*
    Optimized Solution:
    When we just want to traverse the linkedList once, we can use its head 
    directly as the pointer.
*/

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0){// carry != 0 is optimized part
            int v1 = l1 == null? 0 : l1.val;// We directly use l1 and l2 as pointer.
            int v2 = l2 == null? 0 : l2.val;
            l1 = l1 == null? l1 : l1.next;
            l2 = l2 == null? l2 : l2.next;
            int sum = v1 + v2 + carry;
            prev.next = new ListNode(sum % 10);
            prev = prev.next;
            carry = sum / 10;
        }
        return dummy.next;
    }
}