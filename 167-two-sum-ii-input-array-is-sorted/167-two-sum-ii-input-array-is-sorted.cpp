class Solution {
public:
    vector<int> twoSum(vector<int>& numbers, int target) {
        vector<int> res(2u);
        int low = 0;
        int high = numbers.size() - 1;
        
        while(low < high){
            int current_sum = numbers[low] + numbers[high];
            
            if (current_sum == target){
                res[0u] = low + 1;
                res[1u] = high + 1;
            }
            
            if (current_sum > target){
                high--;
            }
            else{
                low++;
            }
        }
        
        
        return res;
    }
};