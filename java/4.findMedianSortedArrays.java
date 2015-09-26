/*
	Problem: find the median of the two sorted Array
	Solution: cut out the first k / 2 element from the array whose k/2 th element is smaller
	Caution: 1. k = 1 edge case
			 2. Use start to cut the array
*/
public class Solution{
	public double findMedianSortedArrays(int[] nums1, int[] nums2){
		int len1 = nums1.length, len2 = nums2.length;
		int mid = (len1 + len2) / 2;
		if((len1 + len2) % 2 == 1) return (double)findKth(nums1, 0, nums2, 0, mid + 1);
		else return ((double)findKth(nums1, 0, nums2, 0, mid) + (double)findKth(nums1, 0, nums2, 0, mid + 1)) / 2.0;
	}

	public int findKth(int[] nums1, int start1, int[] nums2, int start2, int k){
		if(start1  >= nums1.length) return nums2[start2 + k  - 1];
		if(start2  >= nums2.length) return nums1[start1 + k  - 1];
		if(k == 1) return Math.min(nums1[start1], nums2[start2]);

		int key1 = start1 + k / 2 - 1 < nums1.length ? 
		nums1[start1 + k / 2 - 1] : Integer.MAX_VALUE;
		int key2 = start2 + k / 2 - 1 < nums2.length ?
		nums2[start2 + k / 2 - 1] : Integer.MAX_VALUE;

		if(key1 < key2)
			return findKth(nums1, start1 + k / 2, nums2, start2, k - k / 2);
		else
			return findKth(nums1, start1, nums2, start2 + k / 2, k - k / 2); 
	}
}