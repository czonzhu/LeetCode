import Java.util.Random;
public class Solution{
	// Choose the pivot and put number less than it to its left, number 
	// greater than it to its right can get the index of the pivot.
	public int findKthLargest(int nums, k){
		if(nums.length == 0) return nums[0];
		return quickSelect(nums, 0, nums.length - 1, k - 1);
	}

	private int quickSelect(int[] nums, int first, int last, int k){
		if(first <= last){
			int pivot = partition(nums, first, last);
			if(pivot == k) return nums[k];
			if(pivot > k) return quickSelect(nums, first, pivot - 1, k);
			else return quickSelect(nums, pivot + 1, last, k);
		}
		return 0;
	}

	private int partition(int[] nums, int first, int last){
		int pivot = first + new Random().nextInt(last - first + 1);
		swap(nums, last, pivot);
		for(int i = first; i < last; i++){
			if(nums[i] > nums[last]){
				swap(nums, first, i);
				first++;
			}
		}
		swap(nums, first, last);
		return first;
	}

	private void swap(int[] nums, int x, int y){
		int tmp = nums[x];
		nums[x] = nums[y];
		nums[y] = tmp;
	}
}