class Solution {
public:
    int missingNumber(vector<int>& nums) {
        long long res = ((nums.size() + 1) * nums.size()) / 2;
        
        for (int i : nums) {
            res -= i;
        }
        
        return res;
    }
};