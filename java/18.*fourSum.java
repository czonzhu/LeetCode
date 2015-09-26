public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 4) return rst;
        Arrays.sort(nums);// never forget
        for(int p1 = 0; p1 < nums.length - 3; p1++){
            if(p1 > 0 && nums[p1] == nums[p1 - 1]) continue;
            for(int p2 = p1 + 1; p2 < nums.length - 2; p2++){
                if(p2 != p1 + 1 && nums[p2] == nums[p2 - 1])continue;
                int l = p2 + 1, r = nums.length - 1;
                while(l < r){
                    int sum = nums[p1] + nums[p2] + nums[l] + nums[r];
                    if(sum == target){
                        rst.add(new ArrayList<Integer>(Arrays.asList(nums[p1], nums[p2], nums[l], nums[r])));
                        l++;// Never forget one step further
                        r--;
                        while(l < r && nums[l] == nums[l - 1]) l++;// it's inside the sum==0 loop.
                        while(l < r && nums[r] == nums[r + 1]) r--;
                    }
                    else if(sum < target) l++;
                    else r--;
                    
                }
            }
        }
        return rst;
    }
}