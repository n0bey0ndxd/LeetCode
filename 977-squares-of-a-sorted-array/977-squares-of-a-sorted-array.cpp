class Solution {
public:
    vector<int> sortedSquares(vector<int>& nums) {
        vector<int> result(nums.size());
        
        size_t low = 0u;
        size_t high = nums.size() - 1;
        size_t insert_pos = high;
        
        while (low <= high){
            if (low == high){
                result[insert_pos] = nums[low]*nums[low];
                low++;
                
                return result;
            }
            
            if (abs(nums[low]) <= abs(nums[high])){
                result[insert_pos--] = nums[high]*nums[high];
                high--;
            }
            else{
                result[insert_pos--] = nums[low]*nums[low];
                low++;
            }
        }
        
        return result;
    }
};