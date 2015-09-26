public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        //No duplication
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) return rst;
        List<Integer> path = new ArrayList<Integer>();
        helper(rst, path, nums);
        return rst;
    }
    public void helper(List<List<Integer>> rst, List<Integer> path, int[]nums){
        if(path.size() == nums.length) {
            rst.add(new ArrayList<Integer>(path));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(path.contains(nums[i])) continue;// The good use of contains
            path.add(nums[i]);
            helper(rst, path, nums);
            path.remove(path.size() - 1);
        }
        return;
    }
}