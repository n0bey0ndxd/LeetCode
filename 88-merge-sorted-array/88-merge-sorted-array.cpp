class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        if (n == 0){
            return;
        }
        if (m == 0){
            nums1.clear();
            nums1.insert(nums1.begin(), nums2.begin(), nums2.begin() + n);
            return ;
        }
        
        auto iter = nums1.begin() + m;
        
        for (int i = 0u; i < n; i++, iter++){
            *iter = move(nums2[i]);
        }
        
        sort(nums1.begin(), nums1.end());
    }
};