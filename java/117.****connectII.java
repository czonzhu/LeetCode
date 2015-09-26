/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
// Flush from left, too brilliant code.
public class Solution {
    public void connect(TreeLinkNode root) {
        while(root != null){
            TreeLinkNode prev = null, next = null;// Take next as the dummy node
            for(;root != null; root = root.next){
                if(next == null) next = root.left != null ? root.left : root.right;
                if(root.left != null){
                    if(prev != null) prev.next = root.left;
                    prev = root.left;
                }
                if(root.right != null){
                    if(prev != null) prev.next = root.right;
                    prev = root.right;
                }
            }
            root = next;
        }
    }
}