public class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0);
        int reach = 0;
        for(int i = 0; i < nums.length; i++){
            if(i > reach) return false;
            if(reach >= nums.length - 1) return true;
            reach = Math.max(nums[i] + i, reach);
        }
        return true;
    }
}