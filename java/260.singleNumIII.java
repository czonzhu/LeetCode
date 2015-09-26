public class Solution{
	public int[] singleNumber(int[] nums){
		int[] rst = {0, 0};
		if(nums == null || nums.length == 0) return null;
		int diff = 0;
		for(int num : nums) diff ^= num;// Get the right-most set bit which is the diff of the two num
		diff &= -diff;// because two complement: flip + 1 so except the right most bit all other bits are different
		for(int num : nums){
			if((num & diff) == 0) rst[0] ^= num;
			else rst[1] ^= num;
		}
		return rst;
	}
}