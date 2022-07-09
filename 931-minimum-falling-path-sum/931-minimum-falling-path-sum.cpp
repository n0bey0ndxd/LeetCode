class Solution {
private:
    int minElm(int _e1, int _e2, int _e3) {
        return std::min(_e1, std::min(_e2, _e3));
    }
    
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {
        std::vector<std::vector<int>> dp = matrix;
        
        int n = matrix.size();
        int m = matrix.front().size();
        
        for (int r = 1; r < n; r++) {
            for (int c = 0; c < m; c++) {
                dp[r][c] = dp[r][c] + minElm(dp[r - 1][c],
                                    c != 0 ? dp[r - 1][c - 1] : dp[r - 1][c],
                                    c + 1 != m ? dp[r - 1][c + 1] : dp[r - 1][c]);
            }
        }
        
        return *std::min_element(dp.back().begin(), dp.back().end());
    }
};