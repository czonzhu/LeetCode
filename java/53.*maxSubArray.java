public class Solution {
	// 1D DP can use rolling single variable to record
    public int maxSubArray(int[] nums) {
        if(nums == null && nums.length == 0) return 0;
        int rst = Integer.MIN_VALUE, tmp = 0;// How to initialize these two values
        for(int i = 0; i < nums.length; i++){
            tmp = Math.max(nums[i], tmp + nums[i]);
            rst = Math.max(tmp, rst);
        }
        return rst;
    }
}