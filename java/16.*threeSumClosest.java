public class Solution {
    //Use two pointers, sort first.
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3) return 0;// Pay attention to the edge case nums.length < 3
        int rst = nums[0] + nums[1] + nums[nums.length - 1];
        Arrays.sort(nums);// Never, ever, forget to sort when using two pointers.
        for(int i = 0; i < nums.length; i++){
            int l = i + 1, r = nums.length - 1;
            while(l < r){
                int sum = nums[l] + nums[r] + nums[i];
                if(Math.abs(sum - target) < Math.abs(rst - target))
                 rst = sum;
                if(sum < target) l++;
                else r--;
            }
        }
        return rst;
    }
}