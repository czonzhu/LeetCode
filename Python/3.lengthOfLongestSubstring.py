class Solution:
    # @return an integer
    def lengthOfLongestSubstring(self, s):
        m = {}
        j = 0
        rst = 0
        for i, char in enumerate(s):
            if char in m:
                j = max(j, m[char] + 1)
            m[char] = i
            rst = max(i - j + 1, rst)
        return rst
            
                
        