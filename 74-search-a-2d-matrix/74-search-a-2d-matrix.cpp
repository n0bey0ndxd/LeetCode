class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int _row = matrix.size() - 1;
        
        for (size_t i = 0u; i < matrix.size() - 1; i++){
            if (matrix[i][0u] <= target && matrix[i + 1][0u] > target){
                _row = i;
            }
        }

        if (matrix[_row].back() < target || matrix[_row].front() > target){
            return false;
        }
        
        vector<int>& search_line = matrix[_row];
        
        int left = 0u;
        int right = search_line.size() - 1;
        
        //binarySearch
        while (left <= right) {
            int mid = (left + right) / 2;

            if (search_line[mid] == target) {
                return true;
            }

            if (search_line[mid] > target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
	    }   
        
        return false;
    }
};