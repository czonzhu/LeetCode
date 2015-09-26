/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 // 多加一个flag
public class Solution {
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
	    ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
	    boolean reversed = false;
	    Queue<TreeNode> queue = new LinkedList<TreeNode>();
	    queue.offer(A);
	    while(!queue.isEmpty()){
	        int levelNum = queue.size();
	        ArrayList<Integer> list = new ArrayList<Integer>();
	        for(int i = 0; i < levelNum; i++){
    	        TreeNode tmp = queue.poll();
    	        if(!reversed)
    	            list.add(tmp.val);
    	        else
    	            list.add(0, tmp.val);
    	        if(tmp.left != null)
    	            queue.offer(tmp.left);
    	        if(tmp.right != null)
	                queue.offer(tmp.right);
	        }
	        rst.add(list);
	        reversed = !reversed;
	    }
	    return rst;
	}
}