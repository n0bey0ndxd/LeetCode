public class NumMatrix {
    int[][] prefixSum;

    public NumMatrix(int[][] matrix) {
        prefixSum = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if (j == 0){
                    prefixSum[i][j] = matrix[i][j];
                }
                else{
                    prefixSum[i][j] = prefixSum[i][j - 1] + matrix[i][j];
                }
            }
        }


    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;

        for (int i = row1; i <= row2; i++){
            sum += prefixSum[i][col2];
            if (col1 != 0){
                sum -= prefixSum[i][col1 - 1];
            }
        }

        return sum;
    }
}


/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */