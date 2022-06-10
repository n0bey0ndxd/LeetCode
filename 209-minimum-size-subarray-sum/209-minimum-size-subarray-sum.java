class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int result = Integer.MAX_VALUE;
        int prefix_sum = 0;

        while (left <= right && right < nums.length){
            int temp_num = nums[right] + prefix_sum;

            if (temp_num >= target){
                result = Math.min(result, right - left + 1);
                prefix_sum -= nums[left];
                left++;
            }
            else{
                prefix_sum += nums[right];
                right++;
            }
        }


        return result == Integer.MAX_VALUE ? 0 : result;
    }
}