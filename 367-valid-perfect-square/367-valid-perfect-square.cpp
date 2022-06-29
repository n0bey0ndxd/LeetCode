class Solution {
public:
    bool isPerfectSquare(int num) {
        int low = 0;
        int high = 46340; //high^2 closest to INT_MAX
        
        while(low <= high){
            int mid = low + (high - low) / 2;
            int sqr = mid * mid;
            
            if (sqr == num) {
                return true;
            }
            
            if (sqr < num) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        
        return false;
    }
};