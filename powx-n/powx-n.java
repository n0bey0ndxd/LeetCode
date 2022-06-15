class Solution {
    public double myPow(double x, int n) {
        if (n == 0){
            return 1.0;
        }

        double p = myPow(x, n/2);
        double ans = p * p;
        if (n % 2 != 0){
            ans *= n > 0 ? x : 1.0 / x;
        }
        
        return ans;
    }
}