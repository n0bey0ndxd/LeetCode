class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        std::unordered_map<int, int> m;
        
        for (int i : nums) {
            m[i]++;
        }
        
        auto comp = [](const std::pair<int, int>& lhs, const std::pair<int, int>& rhs) {
            return lhs.second < rhs.second;
        };
        std::priority_queue<std::pair<int, int>, std::vector<std::pair<int, int>>, decltype(comp)> heap(comp);
        
        for (auto&& p : m) {
            heap.push(std::move(p));
        }
        
        std::vector<int> res;
        
        while(k--) {
            res.push_back(std::move(heap.top().first));
            heap.pop();
        }
        
        return res;
    }
};