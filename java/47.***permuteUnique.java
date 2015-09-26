public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) return rst;
        List<Integer> path = new ArrayList<Integer>();
        Arrays.sort(nums);
        int[] visited = new int[nums.length]; 
        helper(rst, path, nums, visited);
        return rst;
    }
    
    public void helper(List<List<Integer>> rst, List<Integer> path, int[] nums, int[] visited){
        if(path.size() == nums.length){
            rst.add(new ArrayList<Integer>(path));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(visited[i] == 1 || (i > 0 && visited[i - 1] == 0 && nums[i - 1] == nums[i])) continue;//No bubble
            path.add(nums[i]);
            visited[i] = 1;
            helper(rst, path, nums, visited);
            visited[i] = 0;
            path.remove(path.size() - 1);
        }
        return;
    }
}