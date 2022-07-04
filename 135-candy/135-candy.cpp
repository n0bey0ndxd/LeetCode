class Solution {
public:
    int candy(std::vector<int>& r) {
        if (r.size() < 2) {
            return 1;
        }
        
        int candy = r[0u] <= r[1u] ? 1 : 2;
        int ans = candy;
        int down_count = candy == 2 ? 1 : 0;
        int max = 0;
        
        for (size_t i = 1u; i < r.size(); i++) {
            int prev_candy = candy;
            
            if (r[i] > r[i - 1u]) {
                candy = prev_candy + 1;
                down_count = 0;
                max = candy;
            }
            else if (r[i] == r[i - 1u]) {
                down_count = 1;
                candy = 1;
                max = candy;
            }
            else {
                if (prev_candy == 1) {
                    ans += down_count;
                }
                
                candy = 1;
                down_count++;
                
                if (max == down_count) {
                    max++;
                    ans++;
                }
            }
            
            ans += candy;
        }
        
        return ans;
    }
};