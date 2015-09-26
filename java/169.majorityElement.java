public class Solution{
	public int majorityElement(int[] nums){
		if(nums == null || nums.length == 0) return 0;
		int major = nums[0], count = 0;
		for(int num : nums){
		    if(count == 0){
				major = num;
			}
			if(num == major) count++;
			else count--;
			
		}
		return major;
	}
}