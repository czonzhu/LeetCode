public class Solution{
	public int maximumGap(int[] nums){
		//Construct bucket
		if(nums == null || nums.length < 2) return 0;
		int min = nums[0], max = nums[0];
		for(int num : nums){
			min = Math.min(min, num);
			max = Math.max(max, num);
		}
		int gap = (int)(Math.ceil((double)(max - min) / (nums.length - 1)));
		int[] minBucket = new int[nums.length - 1];
		int[] maxBucket = new int[nums.length - 1];
		Arrays.fill(minBucket, Integer.MAX_VALUE);
		Arrays.fill(maxBucket, Integer.MIN_VALUE);
		for(int num : nums){
			if(num == min || num == max) continue;
			int idx = (num - min) / gap;
			minBucket[idx] = Math.min(minBucket[idx], num);
			maxBucket[idx] = Math.max(maxBucket[idx], num);
		}
		// trace next.min - prev.max;
		int prev = min, maxGap = 0;
		for(int i = 0; i < nums.length - 1; i++){
			if(minBucket[i] == Integer.MAX_VALUE && maxBucket[i] == Integer.MIN_VALUE) continue;
			maxGap = Math.max(maxGap, minBucket[i] - prev);
			prev = maxBucket[i];
		}
		maxGap = Math.max(maxGap, max - prev);
		return maxGap;
	}
}