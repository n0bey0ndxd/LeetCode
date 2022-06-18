class Solution {
    public int[] sortArray(int[] nums) {
        return mergeSort(nums);
    }

    private int[] mergeSort(int[] nums){
        if (nums.length < 2){
            return nums;
        }

        int pivot = nums.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(nums, 0, pivot));
        int[] right = mergeSort(Arrays.copyOfRange(nums, pivot, nums.length));

        return merge(left, right);
    }

    private int[] merge(int[] left, int[] right){
        int[] res = new int[left.length + right.length];
        int r = 0;
        int l = 0;
        int ins = 0;

        while(l < left.length || r < right.length){
            if (l < left.length && r < right.length){
                res[ins++] = left[l] < right[r] ? left[l++] : right[r++];
            }
            else if (l < left.length) {
                res[ins++] = left[l++];
            }
            else{
                res[ins++] = right[r++];
            }
        }

        return res;
    }
}