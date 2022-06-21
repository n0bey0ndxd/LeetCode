class Solution {
    private boolean[] col_attacked;
    private boolean[] diag1_attacked;
    private boolean[] diag2_attacked;
    
    private int n;
    public int totalNQueens(int n) {
        this.n = n;
        col_attacked = new boolean[n];
        diag1_attacked = new boolean[2 * n + 1];
        diag2_attacked = new boolean[2 * n + 1];
        
        return backtrack_nqueen(0, 0);
    }
    
    private int backtrack_nqueen(int row, int count){
        for (int col = 0; col < n; col++){
            if (is_not_attacked(row, col)){
                if (row + 1 == n){
                    count += 1;
                }
                else{
                    place_queen(row, col);
                    count = backtrack_nqueen(row + 1, count);
                    remove_queen(row, col);
                }
            }
        }
        
        return count;
    }
    
    private void place_queen(int row, int col){
        change_statements(row, col, true);
    }
    
    private void remove_queen(int row, int col){
        change_statements(row, col, false);
    }
    
    private boolean is_not_attacked(int row, int col){
        return !col_attacked[col] && !diag1_attacked[row + col] && !diag2_attacked[(n - 1) - col + row];
    }
    
    private void change_statements(int row, int col, boolean state){
        col_attacked[col] = state;
        diag1_attacked[row + col] = state;
        diag2_attacked[(n - 1) - col + row] = state;
    }
}