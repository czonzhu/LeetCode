/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int findPosition(int[] arr, int target){
        for(int i = 0; i < arr.length; i++){
            if(target == arr[i])
                return i;
        }
        return -1;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length != inorder.length) return null;
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    public TreeNode helper(int[] preorder, int ps, int pe, int[] inorder, int is, int ie){
        if(ps > pe || is > ie) return null; //   in: 2   1    34        p: 1 2 34
        TreeNode root = new TreeNode(preorder[ps]);
        int pos = findPosition(inorder, root.val);
        TreeNode left = helper(preorder, ps + 1, ps + pos - is, inorder, is, pos - 1);
        TreeNode right = helper(preorder, ps + 1 + pos - is, pe, inorder, pos + 1, ie);
        root.left = left;
        root.right = right;
        return root;
    }
}