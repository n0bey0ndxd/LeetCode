class Solution {
    private int searchLastPos(int[] nums, int target, int firstPos){
        int left = firstPos;
        int right = nums.length - 1;
        int mid = 0;
        
        while (left <= right){
            mid = (right + left) / 2;
            
            if (nums[mid] == target){
                if (mid == nums.length - 1 
                    || nums[mid + 1] != nums[mid]){
                    return mid;
                }
                else {
                    left = mid + 1;
                }
            }
            
            if (nums[mid] <= target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        
        return -1;
    }
    
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1};
        
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        
        while(left <= right){
            mid = (right + left) / 2;
            
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid - 1] != nums[mid]){
                    result[0] = mid;
                    result[1] = searchLastPos(nums, target, mid);
                    break;
                }
                else{
                    right = mid - 1;
                }
            }
            
            if (nums[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        
        return result;
    }
}