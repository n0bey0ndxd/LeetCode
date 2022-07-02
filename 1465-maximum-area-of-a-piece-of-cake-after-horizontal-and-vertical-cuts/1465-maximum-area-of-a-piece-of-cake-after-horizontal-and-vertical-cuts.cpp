class Solution {
public:
    int maxArea(int h, int w, std::vector<int>& horizontalCuts, std::vector<int>& verticalCuts) {
        std::sort(horizontalCuts.begin(), horizontalCuts.end());
        std::sort(verticalCuts.begin(), verticalCuts.end());
        
        int max_hor = std::max(horizontalCuts.front(), h - horizontalCuts.back());
        int max_ver = std::max(verticalCuts.front(), w - verticalCuts.back());
        
        for (size_t i = 1u; i < verticalCuts.size(); i++) {
            max_ver = std::max(max_ver, verticalCuts[i] - verticalCuts[i - 1u]);    
        }
        
        for (size_t i = 1u; i < horizontalCuts.size(); i++) {
            max_hor = std::max(max_hor, horizontalCuts[i] - horizontalCuts[i - 1u]);
        }
        
        long mod = 1e9 + 7;
        return (long)max_ver * max_hor % mod;
    }
};