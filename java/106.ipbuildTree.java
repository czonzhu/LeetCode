public class Solution{
	public int findPosition(int[] arr, int target){
		for(int i = 0; i < arr.length; i++){
			if(arr[i] == target)
				return i;
		}
		return -1;
	}
	public TreeNode buildTree(int[] inorder, int[] preorder){// in: l--- root r-----      pre: l-----r-----root
		if(inorder.length != preorder.length) return null;
		return helper(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1);
	}
	public TreeNode helper(int[] inorder, int instart, int inend, int[] preorder, int prestart, int preend){
		if(instart > inend || prestart > preend) return null;
		TreeNode root = new TreeNode(preorder[preend]);
		int pos = findPosition(inorder, root.val);
		TreeNode left = helper(inorder, instart, pos - 1, preorder, prestart, prestart + pos - instart - 1);
		TreeNode right = helper(inorder, pos + 1, inend, preorder, prestart + pos - instart, preend - 1);
		root.left = left;
		root.right = right;
		return root;
	}
}