public class Solution{
	public int rob(int[] nums){
		int n = nums.length;
		if(nums == null || nums.length == 0) return 0;
		if(n == 1) return nums[0];
		return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
	}

	private int rob(int[] nums, int start, int end){
		int prevYes = 0, prevNo = 0, rst = 0;
		for(int i = start; i <= end; i++){
			rst = Math.max(prevYes, prevNo + nums[i]);
			prevNo = prevYes;
			prevYes = rst;
		}
		return rst;
	}
}