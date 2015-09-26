public class Solution {
    public boolean search(int[] nums, int target) {
        //1. determine the shape 2. determine the target position.
        if(nums == null || nums.length == 0) return false;
        int l = 0, r = nums.length;
        while(l < r){
            int mid = (l + r) / 2;
            if(nums[mid] == target) return true;
            if(nums[mid]== nums[l]) l++;
            else if(nums[mid] > nums[l]){
                if(target >= nums[l]&&target < nums[mid]) r = mid;
                else l = mid + 1;
            }
            else if(nums[mid] < nums[l]){
                if(target <= nums[r - 1]&&target > nums[mid]) l = mid + 1;
                else r = mid;
            }
        }
        return false;
    }
}