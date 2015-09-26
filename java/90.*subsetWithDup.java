public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // Relate: Permutation Unique
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) return rst;
        Arrays.sort(nums);
        List<Integer> path = new ArrayList<Integer>();
        helper(rst, path, nums, 0);
        return rst;
    }
    public void helper(List<List<Integer>> rst, List<Integer> path, int[] nums, int pos){
        rst.add(new ArrayList<Integer>(path));
        for(int i = pos; i < nums.length; i++){
            if(i != pos && nums[i] == nums[i - 1]) continue;
            path.add(nums[i]);
            helper(rst, path, nums, i + 1);
            path.remove(path.size() - 1);
        }
        return;
    }
}