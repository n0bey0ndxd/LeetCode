class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0){
            return true;
        }
        if (t.length() == 0){
            return false;
        }
        
        int j = 0;
        
        for (int i = 0; i < t.length() && j < s.length(); i++){
            char s_c = s.charAt(j);
            char s_t = t.charAt(i);
            
            if (s_c == s_t){
                j++;
            }
        }
        
        return j == s.length();
    }
}