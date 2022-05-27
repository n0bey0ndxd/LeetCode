class Solution {
public:

    int area(vector<vector<int>>& grid, vector<vector<bool>>& seen, int r, int c){
        int m = grid.size();
        int n = grid[0u].size();
        
        if (r < 0 || r >= m || c < 0 || c >= n || seen[r][c] || grid[r][c] == 0) {
            return 0;
        }
        
        seen[r][c] = true;
        
        int area_size = 1;
        area_size += area(grid, seen, r + 1, c);
        area_size += area(grid, seen, r - 1, c);
        area_size += area(grid, seen, r, c + 1);
        area_size += area(grid, seen, r, c - 1);
        
        
        return area_size;
    }
    
    int maxAreaOfIsland(vector<vector<int>>& grid) {
        int result = 0;
        
        vector<vector<bool>> seen(grid.size(), vector<bool>(grid[0u].size(), false));
        
        for (size_t i = 0u; i < grid.size(); i++){
            for(size_t j = 0u; j < grid[0u].size(); j++){
                if (grid[i][j] == 1){
                    result = max(result, area(grid, seen, i, j));
                }
            }
        }
        
        return result;
    }
};