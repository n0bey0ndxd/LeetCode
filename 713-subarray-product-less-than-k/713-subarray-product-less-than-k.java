class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1){
            return 0;
        }
        
        int result = 0;
        int prod = 1;
        
        for (int i = 0, j = 0;
             i < nums.length && j < nums.length; i++){
            prod *= nums[i];

            while (prod >= k){
                prod /= nums[j];
                j++;
            }

            result += i - j + 1;
        }

        return result;
    }
}