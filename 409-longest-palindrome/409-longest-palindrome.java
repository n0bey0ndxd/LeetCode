class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> m = new HashMap<>();

        int result = 0;
        
        for(int i = 0; i < s.length(); i++){
            Character ch = s.charAt(i);

            m.put(ch, m.getOrDefault(ch, 0) + 1);
            if (m.get(ch) % 2 == 0){
                result += 2;
                
                m.put(ch, 0);
            }
        }
        
        if (m.containsValue(1)){
            result++;
        }
        
        return result;
    }
}