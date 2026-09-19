class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        for(int[]arr: dp){
            Arrays.fill(arr, (int)1e9);
        }
        for(int i = 0; i <= n; i++){
            dp[i][0] = 0;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= amount; j++){
                if(coins[i-1] <= j){
                    int take = 1 + dp[i][j - coins[i-1]];
                    int notTake = dp[i-1][j];
                    dp[i][j] = Math.min(take, notTake);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        int min = dp[n][amount];
        if(min == (int)1e9){
            return -1;
        }
        return min;
    }
}
