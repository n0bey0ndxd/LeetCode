class Solution {
    private Integer[][] memo;
    
    public int uniquePaths(int m, int n) {
        memo = new Integer[m][n];
        
        if (m == 1 && n == 1) {
            return 1;
        }
        
        return dp(m - 2, n - 1) + dp(m - 1, n - 2);
    }
    
    private int dp(int m, int n) {
        if (n <= 0 || m <= 0) {
            return n < 0 || m < 0 ? 0 : 1;
        }
        
        if (memo[m][n] != null) {
            return memo[m][n];
        }
        
        int result = dp(m - 1, n) + dp(m, n - 1);
        
        return memo[m][n] = result;
    }
}