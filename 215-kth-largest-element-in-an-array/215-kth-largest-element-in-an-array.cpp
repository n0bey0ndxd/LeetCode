class Solution {
public:
    int findKthLargest(std::vector<int>& nums, int k) {
        std::priority_queue<int, std::deque<int>, std::greater<int>> p_q;

        for (int i : nums) {
            p_q.push(i);

            if (p_q.size() == k + 1) {
                p_q.pop();
            }
        }

        return p_q.top();
    }
};