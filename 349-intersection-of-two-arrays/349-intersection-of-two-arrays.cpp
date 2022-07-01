class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        std::sort(nums1.begin(), nums1.end());
        std::sort(nums2.begin(), nums2.end());
        
        std::set<int> set;
        
        for (int i : nums1) {
            if (binSearch(nums2, i)){
                set.insert(i);
            }
        }
        
        for (int i : nums2) {
            if (binSearch(nums1, i)){
                set.insert(i);
            }
        }
        
        return std::vector<int>(set.begin(), set.end());
    }
    
    bool binSearch(const vector<int>& nums, int target) {
        int left = 0;
        int right = nums.size() - 1;
        
        while(left <= right){
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return true;
            }
            
            if (nums[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        
        return false;
    }
};