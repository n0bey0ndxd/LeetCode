class Solution {
    public boolean checkPossibility(int[] nums) {
        if (nums.length < 3){
            return true;
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        boolean modified = false;

        for (int i = 0; i + 1 < nums.length; i++){
            if (nums[i] > nums[i + 1]){
                if (modified){
                    return false;
                }

                if (!heap.isEmpty() &&
                        heap.peek() > nums[i + 1]){
                    nums[i + 1] = heap.peek() > nums[i] ? heap.peek() : nums[i];
                }
                else{
                    nums[i] = nums[i + 1];
                }

                modified = true;
            }

            heap.add(nums[i]);
        }

        return true;
    }
}