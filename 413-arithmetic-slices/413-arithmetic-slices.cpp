class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& nums) {
        int result = 0;

        if (nums.size() < 3) {
            return 0;
        }

        for (size_t i = 1u; i < nums.size(); i++) {
            int difference = nums[i] - nums[i - 1u];

            if (i + 1u == nums.size()) {
                break;
            }

            int next_difference = nums[i + 1u] - nums[i];

            for (size_t j = i; next_difference == difference && j < nums.size(); ) {
                result++;
                j++;
                if (j + 1 < nums.size()) {
                    difference = next_difference;
                    next_difference = nums[j + 1u] - nums[j];
                }
                else {
                    break;
                }
            }
        }

        return result;
    }
};