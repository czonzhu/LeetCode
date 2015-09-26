public class Solution {
    //Bottom-up
	private ListNode head = null;
    public TreeNode sortedListToBST(ListNode head) {
    	if(head == null) return null;
    	ListNode p = head;
    	int len = 1;
    	while(p.next != null){
    		p = p.next;
    		len++;
    	}
    	this.head = head;
    	return helper(0, len - 1);
    }
    public TreeNode helper(int start, int end){
    	if(start > end) return null;
    	int mid = start + (end - start) / 2;// prevent overflow
    	TreeNode left = helper(start, mid - 1);
    	TreeNode cur = new TreeNode(head.val);
    	head = head.next;
    	cur.left = left;
    	cur.right = helper(mid + 1, end);
    	return cur;
    }
}