public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        int[] rst = {0, 0};
        while(l < r){
            int sum = numbers[l] + numbers[r];
            if(sum == target){
                rst[0] = l + 1;
                rst[1] = r + 1; 
                return rst;
            }
            else if(sum < target) l++;
            else r--;
        }
        return null;
    }
}