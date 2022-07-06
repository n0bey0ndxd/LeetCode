class Solution {
public:
    int fib(int n) {
        int f1 = 0;
        int f2 = 1;
        
        while (n--) {
            int x = f1 + f2;
            f1 = f2;
            f2 = x;
        }
        
        return f1;
    }
};