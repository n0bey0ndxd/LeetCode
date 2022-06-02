class Solution {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] res_mat = new int[n][m];
        
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                res_mat[j][i] = matrix[i][j];
            }
        }
        
        return res_mat;
    }
}