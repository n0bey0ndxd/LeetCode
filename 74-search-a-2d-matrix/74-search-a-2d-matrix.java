public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length - 1;
        int mid = -1;
        int end_Indx = matrix[0].length - 1;

        if (matrix[right][end_Indx] < target){
            return false;
        }

        while(left <= right){
            mid = (left + right) / 2;

            if (matrix[mid][0] <= target && matrix[mid][end_Indx] >= target) {
                break;
            }

            if (matrix[mid][0] > target){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }

        }

        if (left > right){
            return false;
        }

        int row = mid;

        int _left = 0;
        int _right = matrix[0].length - 1;
        int _mid = -1;

        while (_left <= _right){
            _mid = (_left + _right) / 2;

            if (matrix[row][_mid] == target){
                return true;
            }

            if (matrix[row][_mid] < target){
                _left = _mid + 1;
            }
            else {
                _right = _mid - 1;
            }
        }

        return false;
    }
}