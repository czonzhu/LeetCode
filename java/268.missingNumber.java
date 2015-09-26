public class Solution{
	public int missingNumber(int[] nums){
		int rst = nums.length;
		int i = 0;
		for(int num : nums){
			rst ^= num;
			rst ^= i;
			i++;
		}
		return rst;
	}
}