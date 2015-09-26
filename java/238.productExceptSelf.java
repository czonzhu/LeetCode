public class Solution{
	public int[] productExceptSelf(int[] nums){
		int[] rst = new int[nums.length];
		if(nums == null || nums.length == 0) return rst;
		rst[0] = 1;
		for(int i = 1; i < nums.length; i++){
			rst[i] = rst[i - 1] * nums[i - 1];
		}
		int right = 1;
		for(int i = nums.length - 1; i >= 0; i--){
			rst[i] *= right;
			right *= nums[i];
		}
		return rst;
	}
}