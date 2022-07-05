class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        std::unordered_set<int> s;
        
        for (int i : nums) {
            s.insert(i);
        }
        
        int ans = 0;
        
        for (int i : s) {
            if (s.find(i - 1) == s.end()){
                int num = i;
                int streak = 1;
                
                while(s.find(num + 1) != s.end()){
                    streak++;
                    num++;
                }
                
                ans = std::max(streak, ans);
            }
        }
        
        return ans;
    }
};