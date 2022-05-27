class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        k = k % nums.size();
        auto it_right = nums.end() - k;
        
        vector<int> temp_v;
        temp_v.insert(temp_v.end(), make_move_iterator(nums.begin()), make_move_iterator(it_right));
        nums.erase(nums.begin(), it_right);
        nums.insert(nums.end(), make_move_iterator(temp_v.begin()),  make_move_iterator(temp_v.end()));
    }
};