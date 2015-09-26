public class Solution {
    public int singleNumber(int[] nums) {
    	// This problem has tons of extensions.
        if(nums == null || nums.length == 0) return 0;
        int rst = 0;
        for(int n : nums)
            rst ^= n;
        return rst;
    }
}