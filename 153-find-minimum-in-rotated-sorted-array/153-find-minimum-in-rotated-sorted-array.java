class Solution {
    public int findMin(int[] nums) {
        if (nums[0] <= nums[nums.length - 1]){
            return nums[0];
        }

        if (nums.length == 2){
            return nums[1];
        }

        int left = 0;
        int right = nums.length - 1;
        int mid = -1;

        while(left <= right){
            mid = (right + left) / 2;

            if (mid == 0){
                mid = 1;
                break;
            }

            if (nums[mid] < nums[mid - 1]){
                break;
            }

            if (nums[mid] < nums[0]){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }

        return nums[mid];
    }
}