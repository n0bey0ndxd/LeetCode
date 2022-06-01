class Solution {
    private int binarySearch(int[] nums, int target, int r_ix){
        boolean toRight = r_ix == 0 || target <= nums[nums.length - 1];

        int left = toRight ? r_ix : 0;
        int right = toRight ? nums.length - 1 : r_ix;
        int mid = 0;

        while(left <= right){
            mid = (right + left) / 2;

            if (nums[mid] == target){
                return mid;
            }

            if (nums[mid] > target){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }

        return -1;
    }


    public int search(int[] nums, int target) {
        if (nums[0] <= nums[nums.length - 1]){
            return binarySearch(nums, target, 0);
        }

        if (nums.length < 3){
            if (nums[0] <= nums[nums.length - 1]){
                return binarySearch(nums, target, 0);
            }
            else {
                return binarySearch(nums, target, 1);
            }
        }

        int left = 0;
        int right = nums.length - 1;
        int mid = 0;

        int tempMid = (left + right) / 2;
        boolean isRight = nums[left] > nums[tempMid];

        if (isRight){
            right = tempMid;
        }
        else {
            left = tempMid;
        }

        while(left <= right){
            mid = (right + left) / 2;

            if (mid == 0){
                return binarySearch(nums, target, mid + 1);
            }
            
            if (nums[mid] < nums[mid - 1]){
                    return binarySearch(nums, target, mid);
            }

            if (nums[mid] > nums[right]){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }

        return -1;
    }
}
