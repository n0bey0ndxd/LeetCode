class Solution {
public:
    std::vector<int> searchRange(std::vector<int>& nums, int target) {
        if (nums.size() == 0) {
            return { -1, -1 };
        }

        int left = 0;
        int right = nums.size() - 1;
        std::vector<int> res = { -1, -1 };
        
        if (nums[left] == target) {
            res[0] = left;
        }
        if (nums[right] == target) {
            res[1] = right;
        }

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                if (nums[mid - 1] != target) {
                    res[0] = mid;
                    right = nums.size() - 1;
                }
                if (nums[mid + 1] != target) {
                    res[1] = mid;
                    left = 0;
                }

                if (res[1] == -1) {
                    left = mid;
                }
                else if (res[0] == -1) {
                    right = mid;
                }
                else {
                    return res;
                }
            }
            else {
                if (nums[mid] < target) {
                    left = mid;
                }
                else {
                    right = mid;
                }
            }
        }

        if (nums[left] == target || nums[right] == target) {
            if (res[0] == -1) {
                res[0] = nums[left] == target ? left : right;
            }
            if (res[1] == -1) {
                res[1] = nums[right] == target ? right : left;
            }
        }

        return res;
    }
};