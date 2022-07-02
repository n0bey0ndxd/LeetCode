class Solution {
public:
    int findMaxConsecutiveOnes(vector<int>& nums) {
        int max = 0;
        int count = 0;
        for (int i : nums) {
            if (i == 0) {
                count = -1;
            }
            
            count++;
            max = std::max(max, count);
        }
        
        return max;
    }
};