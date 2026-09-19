class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        if(target < 0){
            target  = -target;
        }
        int n = nums.length;
        int sum = 0;
        for(int num:nums) sum += num;
        int reqSum = target + sum;
        if(target > sum || reqSum % 2 != 0) return 0;
        else{
            reqSum /= 2;
        }
        int[][] dp = new int[n+1][reqSum + 1];
        
        dp[0][0] = 1;

        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= reqSum; j++){
                int take = 0;
                int notTake = dp[i-1][j];
                if(nums[i-1] <= j) take = dp[i-1][j- nums[i-1]];

                dp[i][j] = take + notTake;
            }
        }

        return dp[n][reqSum];
    }
}