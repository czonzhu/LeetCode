public class Solution{
	public int jump(int[] nums){
		int nextMax = 0, count = 0, curMax = 0;
		for(int i = 0; i < nums.length; i++){
			if(nextMax < i) return -1;
			if(curMax >= nums.length - 1) return count;
			if(i > curMax){
				curMax = nextMax;
				count++;
			}
			nextMax = Math.max(nextMax, nums[i] + i);
		}
		return count;
	}
}