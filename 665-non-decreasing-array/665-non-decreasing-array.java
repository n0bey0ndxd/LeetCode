class Solution {
    public boolean checkPossibility(int[] nums) {
        if (nums.length < 3){
            return true;
        }

        int max = Integer.MIN_VALUE;
        boolean modified = false;

        for (int i = 0; i + 1 < nums.length; i++){
            if (nums[i] > nums[i + 1]){
                if (modified){
                    return false;
                }

                if (max > nums[i + 1]){
                    nums[i + 1] = max > nums[i] ? max : nums[i];
                }
                else{
                    nums[i] = nums[i + 1];
                }

                modified = true;
            }

            max = Math.max(max, nums[i]);
        }

        return true;
    }
}