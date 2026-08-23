class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for(int i = 0; i < nums.length; i++){
            currSum += nums[i];
            if(currSum < 0){
                currSum = 0;
            }
            maxSum = Math.max(maxSum, currSum);
        }
        if(maxSum == 0){
            maxSum = nums[0];
            for(int i = 1; i < nums.length; i++){
                maxSum = Math.max(maxSum, nums[i]);
            }
        }
        return maxSum;
    }
}
