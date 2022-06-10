class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();

        int result = 0;
        int local_max = 0;

        int left = 0;
        int right = 0;

        for (; right < s.length(); right++){
            char ch = s.charAt(right);

            if (!set.contains(ch)){
                local_max++;
                result = Math.max(result, local_max);
                set.add(ch);
            }
            else{
                while(s.charAt(left) != ch){
                    local_max--;
                    set.remove(s.charAt(left++));
                }
                left++;
            }
        }

        return result;
    }
}