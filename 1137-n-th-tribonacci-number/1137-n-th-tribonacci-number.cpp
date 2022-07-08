class Solution {
public:
    int tribonacci(int n) {
        uint64_t f1 = 0;
        uint64_t f2 = 1;
        uint64_t f3 = 1;
        
        while(n--) {
            uint64_t temp = f1 + f2 + f3;
            f1 = f2;
            f2 = f3;
            f3 = temp;
        }
        
        return f1;
    }
};