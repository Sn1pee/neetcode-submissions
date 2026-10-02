class Solution {
    public int lengthOfLIS(int[] nums) {
        Set<Integer> st = new HashSet<>();
        for(int i: nums) st.add(i);
        int[] arr2 = new int[st.size()];
        int i = 0;
        for(int num: st){
            arr2[i] = num;
            i++;
        }
        Arrays.sort(arr2);
        int n = nums.length;
        int m = arr2.length;
        int[][] dp = new int[n+1][m+1];

        for(i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(nums[i-1] == arr2[j-1]){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[n][m];
    }
}
