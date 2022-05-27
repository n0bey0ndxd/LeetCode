class Solution {
public:
    bool isValid(string_view s) {
        deque<char> d;
        for (auto c : s) {
            switch (c)
            {
            case '(':
            {
                d.push_back('(');
            }
                break;
            case ')':
            {
                if (!d.empty() && d.back() == '(') {
                    d.pop_back();
                }
                else {
                    return false;
                }
            }
                break;
            case '{':
            {
                d.push_back('{');
            }
                break;
            case '}':
            {
                if (!d.empty() && d.back() == '{') {
                    d.pop_back();
                }
                else {
                    return false;
                }
            }
                break;
            case '[':
            {
                d.push_back('[');
            }
                break;
            case ']':
            {
                if (!d.empty() && d.back() == '[') {
                    d.pop_back();
                }
                else {
                    return false;
                }
            }
                break;
            }
        }
        
        return d.empty();
    }
};