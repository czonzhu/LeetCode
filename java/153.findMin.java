public class Solution{
	// 二分法两种，一种用mid 找 target 一种让指针相遇（search for a range.
	// 第一种可以将右边设为length作为[) pattern 第二种则要么让两指针重合(l < r)要么相遇不重合(l < r - 1) l = mid, r = mid
	//若让指针重合则看相遇位置在条件的哪里。这道题相遇是在mid>R所以l = mid +1
	//指针相遇的情况绝对不可以越界
	//判断形状是 mid > num[l] 在 
	//这道题是个夹逼问题，target是到返回mid问题
	public int findMin(int[] A){
		int L = 0, R = A.length - 1;
		while(L < R){
			int mid = L + (R - L) / 2; 
			if(A[mid] > A[R])L = mid + 1;//
			else R = mid;
		}
		return A[L];
	}
}
/*
	public class Solution {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return false;
        int l = 0, r = nums.length;
        while(l < r){
            int mid = (l + r) / 2;
            if(nums[mid] == target) return true;
            if(nums[mid] == nums[l]) l++;
            else if(nums[mid] > nums[l]){// 判断mid 位置也可以用 mid > num[r - 1]
                if(target < nums[mid] && target >= nums[l]) r = mid;
                else l = mid + 1;
            }
            else{
                if(target > nums[mid] && target <= nums[r - 1]) l = mid + 1;
                else r = mid;
            }
        }
        return false;
    }
}
	
*/