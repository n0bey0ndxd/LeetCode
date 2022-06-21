class Solution {
    boolean[][] rows = new boolean[9][9];
    boolean[][] cols = new boolean[9][9];
    boolean[][][] boxes = new boolean[3][3][9];
    int REDIX = 10;

    private void fillStatments(char[][] board){
        for (int row = 0; row < cols.length; row++){
            for (int col = 0; col < rows.length; col++){
                char b_c = board[row][col];

                if (b_c != '.'){
                    int digit = Character.digit(b_c, REDIX) - 1;

                    rows[row][digit] = true;
                    cols[col][digit] = true;
                    boxes[row / 3][col / 3][digit] = true;
                }
            }
        }
    }

    public void solveSudoku(char[][] board) {
        fillStatments(board);
        backtrack_sudoku(0,0, board);
    }

    private boolean backtrack_sudoku(int row, int col, char[][] board){
        boolean isSolved = false;

        if (board[row][col] == '.'){
            for (int digit = 1; digit < 10; digit++){
                if (checkValidNumber(row, col, digit)){
                    place_digit(row, col, digit, board);

                    if (col + 1 == cols.length){
                        if (row + 1 == rows.length){
                            return true;
                        }

                        isSolved = backtrack_sudoku(row + 1, 0, board);
                    }
                    else{
                        isSolved = backtrack_sudoku(row, col + 1, board);
                    }

                    if (isSolved){
                        return true;
                    }

                    remove_digit(row, col, digit, board);
                }
            }
        }
        else{
            if (col + 1 != cols.length){
                isSolved = backtrack_sudoku(row, col + 1, board);
            }
            else{
                if (row + 1 == rows.length){
                    return true;
                }

                isSolved = backtrack_sudoku(row + 1, 0, board);
            }

            if (isSolved){
                return true;
            }
        }

        return false;
    }

    private boolean checkValidNumber(int row, int col, int digit){
        boolean flag_r = !rows[row][digit-1];
        boolean flag_c = !cols[col][digit-1];
        boolean flag_bx = !boxes[row / 3][col / 3][digit-1];
        return  flag_r && flag_c && flag_bx;
    }

    private void place_digit(int row, int col, int digit, char[][] board){
        changeStatements(row, col, digit, board, true);
    }

    private void remove_digit(int row, int col, int digit, char[][] board){
        changeStatements(row, col, digit, board, false);
    }

    private void changeStatements(int row, int col, int digit, char[][] board, boolean state){
        rows[row][digit-1] = state;
        cols[col][digit-1] = state;
        boxes[row / 3][col / 3][digit-1] = state;
        board[row][col] = state ? toChar(digit) : '.';
    }

    private char toChar(int digit){
        return Character.forDigit(digit, REDIX);
    }
}