class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int profit = 0;
        int price = prices[0u];
        
        for(int i = 1; i < prices.size(); i++){
            if(price > prices[i]){
                price = prices[i];
            }
            else{
                profit = max(profit, prices[i] - price);
            }
        }
        
        return profit;
    }
};