class Solution {
public:
    std::vector<int> findClosestElements(std::vector<int>& arr, int k, int x) {
        int left = 0;
        int right = k;
        int end = arr.size();

        while (right < end) {
            int mid = (right + end) / 2;
            int n = mid - right;

            if (x - arr[left + n] > arr[mid] - x) {
                left += n + 1;
                right = mid + 1;
            }
            else {
                end = mid;
            }
        }

        return std::vector<int>(arr.begin() + left, arr.begin() + right);
    }
};