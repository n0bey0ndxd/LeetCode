class Solution {
    public void reverseString(char[] s) {
        revS(0, s);
    }
    
    private void revS(int index, char[] s){
        if (index >= s.length / 2){
            return;
        }
        
        revS(index + 1, s);
        char t = s[index];
        s[index] = s[s.length - 1 - index];
        s[s.length - 1 - index] = t;
    }
}