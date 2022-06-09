class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int right = numbers.length - 1;
        int left = 0;

        while (left < right){
            int temp_sum = numbers[left] + numbers[right]; 
            
            if (target == temp_sum) {
                break;
            }
            
            if (target < temp_sum){
                right--;
            }
            else{
                left++;
            }
        }

        return IntStream.of(left + 1, right + 1).toArray();
    }
}