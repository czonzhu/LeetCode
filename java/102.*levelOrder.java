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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if(root == null) return rst;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> level = new ArrayList<Integer>();
        queue.offer(root);
        while(!queue.isEmpty()){
            level = new ArrayList<Integer>();
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
                level.add(cur.val);
            }
            rst.add(new ArrayList<Integer>(level));
        }
        return rst;
    }
}