class Solution:
	def twoSum(self, nums, target):
		if(len(nums) == 0): return[-1, -1]
		m = {}
		for i, num in enumerate(nums):
			if(target - num) in m:
				return[m[target - m], i + 1]
			m[num] = i + 1
		return[-1, -1]