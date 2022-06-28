class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int min = nums[0];
        
        while(left < right){
            int mid = (left + right) / 2;
            
            if (nums[mid] > nums[mid + 1]){
                return nums[mid + 1];
            }
            
            if (nums[mid] > min){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        
        return min;
    }
}