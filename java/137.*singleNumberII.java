public class Solution{
	public int singleNumber(int[] nums){
		if(nums == null || nums.length == 0) return 0;
		int[] bits = new int[32];
		int rst = 0;
		// 1. 记录 2. 结算
		for(int i = 0; i < 32; i++){//  for 循环也要讲究顺序， 所有数字完结才能结算
			for(int j = 0; j < nums.length; j++){
				bits[i] += (nums[j] >> i) & 1;
				bits[i] %= 3;
			}
			rst |= (bits[i]<<i);
		}
		return rst;
	}
}