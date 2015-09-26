public class Solution{
	public int minSubArrayLen(int s, int[] nums){
		// Sliding window module
		if(nums == null || nums.length == 0) return 0;
		int l = 0, min = Integer.MAX_VALUE, sum = 0;
		for(int r = 0; r < nums.length; r++){
			sum += nums[r];
			while(l <= r && sum >= s){//key part
				min = Math.min(min, r - l + 1);
				sum -= nums[l++];
			}
		}
		return min == Integer.MAX_VALUE ? 0 : min;
	}
}