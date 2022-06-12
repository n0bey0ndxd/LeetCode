class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int local = 0;
        int result = 0;
        int left = 0;
        int right = 0;

        while(right != nums.length){
            int target = nums[right];

            if (set.contains(target)){
                while(nums[left] != target){
                    set.remove(nums[left]);
                    local -= nums[left++];
                }
                
                right++;
                left++;
            }
            else{
                set.add(target);
                local += nums[right++];
                result = Math.max(result, local);
            }
        }

        return result;
    }
}