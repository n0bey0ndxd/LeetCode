class Solution {
    public int maxProfit(int[] prices) {
        int local_min = prices[0];
        int result = 0;
        
        for (int i = 1; i < prices.length; i++){
            if (prices[i] < local_min){
                local_min = prices[i];
            }
            else{
                result = Math.max(prices[i] - local_min, result);
            }
        }
        
        return result;
    }
}