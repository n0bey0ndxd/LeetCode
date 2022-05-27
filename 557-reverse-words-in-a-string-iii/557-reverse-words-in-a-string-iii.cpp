class Solution {
public:
    string reverseWords(string s) {
        size_t pos = 0u;
	    size_t pos_of_Space = s.find(' ');

        if (pos_of_Space == s.npos) {
            reverse(s.begin(), s.end());
            return s;
        }

        while (pos_of_Space != s.npos) {
            reverse(s.begin() + pos, s.begin() + pos_of_Space);

            pos = pos_of_Space + 1;
            pos_of_Space = s.find(' ', pos);

            if (pos_of_Space == s.npos) {
                reverse(s.begin() + pos, s.end());
            }
        }

	    return s;
    }
};