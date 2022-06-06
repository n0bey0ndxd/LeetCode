class Solution {
    public int maxArea(int[] height) {
        int right = height.length - 1;
        int left = 0;

        int result = 0;

        while(left < right){
            result = Math.max(result, Math.min(height[left], height[right]) * (right - left));

            if (height[right] <= height[left]){
                right--;
            }
            else{
                left++;
            }
        }

        return result;
    }
}