class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        if (s.size() < p.size()) {
            return {};
        }
        std::unordered_map<char, int> m_p;
        std::unordered_map<char, int> m_s;
        vector<int> res;

        for (char c : p) {
            m_p[c]++;
        }

        int k = p.size() - 1;

        for (int i = 0; i < s.size() - k; i++) {
            if (m_s.empty()) {
                int j = i;
                for (; j <= i + k; j++) {
                    m_s[s[j]]++;
                }
                //continue;
            }
            else {
                m_s[s[i + k]]++;
            }

            if (m_p.find(s[i + k]) == m_p.end()) {
                m_s.clear();
                i += k;
                continue;
            }

            bool flag = true;
            for (const auto& item : m_p) {
                if (item.second != m_s[item.first]) {
                    flag = false;
                    break;
                }
            }

            m_s[s[i]]--;

            if (flag) {
                res.push_back(i);
            }
        }

        return res;
    }
};