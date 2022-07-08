class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        std::unordered_map<string, vector<string>> m;
        
        for (std::string& str : strs) {
            std::string s = str;
            std::sort(s.begin(), s.end());
            
            m[s].push_back(str);
        }
        
        vector<vector<string>> res;
        for (auto& item : m) {
            res.push_back(std::move(item.second));
        }
        
        return res;
    }
};