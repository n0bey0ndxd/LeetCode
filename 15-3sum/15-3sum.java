class Solution {
    private void twoSum(int[] nums, Set<List<Integer>> s, int ix){
        int target = 0 - nums[ix];

        int l = 0;
        int r = nums.length - 1;

        while (l < r){
            if (nums[l] + nums[r] == target){
                if (l != ix && r != ix){
                    s.add(Stream.of(nums[r], nums[l], nums[ix]).sorted().collect(Collectors.toList()));
                }
                l++;
                //r--;
            }

            if (nums[l] + nums[r] > target){
                r--;
            }
            else{
                l++;
            }
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
if (nums.length < 3){
            return new ArrayList<>();
        }

        int[] arr = Arrays.stream(nums).sorted().toArray();
        
        if (Arrays.stream(nums).distinct().count() == 1){
            arr = Arrays.stream(nums).limit(3).toArray();    
        };
        
        Set<List<Integer>> s = new HashSet<>();
        for (int i = 0; i < arr.length; i++){
            twoSum(arr, s, i);
        }

        return s.stream().toList();
    }
}