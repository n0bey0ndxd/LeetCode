class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        if (s.size() < p.size()) {
            return {};
        }

        std::vector<int> m_p(26, 0);
        std::vector<int> m_s(26, 0);
        vector<int> res;

        for (char c : p) {
            m_p[c - 'a']++;
        }

        int k = p.size() - 1;

        for (int j = 0; j < k; j++) {
            m_s[s[j] - 'a']++;
        }

        for (int i = 0; i < s.size() - k; i++) {
            m_s[s[i + k] -'a']++;

            bool flag = true;
            for (int i = 0; i < m_p.size(); i++) {
                if (m_p[i] != m_s[i]) {
                    flag = false;
                    break;
                }
            }

            m_s[s[i] - 'a']--;

            if (flag) {
                res.push_back(i);
            }
        }

        return res;
    }
};