public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i = m + n - 1; i >= 0 && n >= 1; i--){
            nums1[i] = (m < 1|| nums1[m - 1] < nums2[n - 1]) ?  nums2[-1 + n--] : nums1[-1 + m--] ;
        }
        return ;
    }
}