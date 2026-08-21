class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        
        int currPrice = prices[0];
        for(int i = 1; i < prices.length; i++){
            if(currPrice > prices[i]){
                currPrice = prices[i];
            }
            else{
                int profit = prices[i] - currPrice;
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        return maxProfit;
    }
}
