class Solution {
public:
    int minimumTotal(vector<vector<int>>& triangle) {
        std::vector<std::vector<int>> dp = triangle;
        
        int n = triangle.size();
        
        for (int i = 1; i < n; i++) {
            int m = triangle[i].size();            
            for (int j = 0; j < m; j++) {
                if (j != 0) {
                    if (j + 1 != m) {
                        dp[i][j] += std::min(dp[i - 1][j], dp[i - 1][j - 1]);
                    }
                    else {
                        dp[i][j] += dp[i - 1][j - 1];
                    }
                }
                else {
                    dp[i][j] += dp[i - 1][j];
                }
            }
        }
        
        return *std::min_element(dp.back().begin(), dp.back().end());
    }
};