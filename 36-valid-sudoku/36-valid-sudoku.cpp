class Solution {
private:
    std::array<std::unordered_set<int>, 9> cols;
    std::array<std::unordered_set<int>, 9> rows;
    std::array<std::unordered_set<int>, 9> boxs;
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board.size(); j++) {
                if (board[i][j] != '.') {
                    int dig = board[i][j] - '1';
                    int b = i / 3 * 3 + j / 3; 
                    
                    if (cols[j].find(dig) == cols[j].end() &&
                        rows[i].find(dig) == rows[i].end() &&
                        boxs[b].find(dig) == boxs[b].end()) {
                        cols[j].insert(dig);
                        rows[i].insert(dig);
                        boxs[b].insert(dig);
                    }
                    else {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
};