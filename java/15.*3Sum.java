public class Solution {
    // jump after taken the first other wise [0, 0, 0] case wont be satisfied
    // Extension: 1. What if the number can be used multiple times? 2. Find N-sum equals to 0 : Combination Sum ii, backtracking.
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 3) return rst;
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length; i++){
            int l = i + 1, r = nums.length - 1;
            
            if(i > 0 && nums[i] == nums[i - 1]) continue;// jump dup after taken the first
            
            while(l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if(sum == 0) {
                    rst.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[l], nums[r])));//the use of asList
                    l++;// dont forget
                    r--;
                    while(l < r && nums[l] == nums[l - 1]) l++;// no l > i + 1, after we taken the first 
                    while(l < r && nums[r] == nums[r + 1]) r--;// no r < len - 1, l < r condition is easy to be forgot
                    
                }
                else if(sum < 0) l++;
                else r--;
            }
        }
        return rst;
    }
}