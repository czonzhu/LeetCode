class Solution:
    # @return a ListNode
    def addTwoNumbers(self, l1, l2):
        if(l1 == None and l2 == None): return None
        if(l1 == None): return l2
        if(l2 == None): return l1
        prev = dummy = ListNode(0)
        carry = 0
        while(l1 or l2 or carry != 0):
            v1 = l1.val if l1 else 0
            v2 = l2.val if l2 else 0
            l1 = l1.next if l1 else None
            l2 = l2.next if l2 else None
            sum = v1 + v2 + carry
            prev.next = ListNode(sum % 10)
            prev = prev.next
            carry = sum / 10
        return dummy.next