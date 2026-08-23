class Solution:
    def maxArea(self, height: List[int]) -> int:
        l, r = 0 , len(height) - 1
        maxarea = 0
        while l < r:
            area = min(height[l], height[r]) * (r - l)
            maxarea = max(maxarea, area)
            if height[l] < height[r]:
                l += 1
            else:
                r -= 1
        return maxarea