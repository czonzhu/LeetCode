public class Solution{
	public int maxProduct(int[] nums){
		if(nums == null || nums.length == 0) return 0;
		int min = nums[0], max = nums[0], rst = nums[0];// min and max means the min and max with or without number before nums[i], it has to contain nums[i]
		for(int i = 1; i < nums.length; i++){
			int tmpmin = min, tmpmax = max;
			min = Math.min(nums[i], Math.min(nums[i] * tmpmax, nums[i] * tmpmin));
			max = Math.max(nums[i], Math.max(nums[i] * tmpmin, nums[i] * tmpmax));
			rst = Math.max(rst, max);// -4, -3, -2
		}
		return rst;
	}
}