class Solution {
    public int mySqrt(int x) {
        int left = 0;
        int right = 46340; //sqrt(2^32 - 1)

        while(left <= right){
            int mid = (left + right) / 2;
            int sqt = mid * mid;
            
            if (sqt == x){
                return mid;
            }
            
            if (x > sqt){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        
        return left - 1;
    }
}