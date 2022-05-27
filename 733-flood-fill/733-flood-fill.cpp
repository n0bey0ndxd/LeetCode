class Solution {
public:
    void dfs(vector<vector<int>>& image, int sr, int sc, int newColor, int base_color){
        
        int m = image.size();
        int n = image[sr].size();
        
        if (sr != 0 && image[sr - 1][sc] == base_color){
            image[sr - 1][sc] = newColor;
            dfs(image, sr - 1, sc, newColor, base_color);
        }
        if (sr + 1 < m && image[sr + 1][sc] == base_color){
            image[sr + 1][sc] = newColor;
            dfs(image, sr + 1, sc, newColor, base_color);
        }
        if (sc != 0 && image[sr][sc - 1] == base_color){
            image[sr][sc - 1] = newColor;
            dfs(image, sr, sc - 1, newColor, base_color);
        }
        if (sc + 1 < n && image[sr][sc + 1] == base_color){
            image[sr][sc + 1] = newColor;
            dfs(image, sr, sc + 1, newColor, base_color);
        }
    }
    
    
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
        int base_color = image[sr][sc];
        
        if (base_color == newColor){
            return image;
        }
        
        image[sr][sc] = newColor;
        dfs(image, sr, sc, newColor, base_color);
            
        return image;
    }
};