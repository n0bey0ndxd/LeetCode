class Solution {
    public int numberOfSteps(int num) {
        if (num == 0){
            return 0;
        }
        
        int res = -1;
        
        while (num != 0){
            res += (num & 1) != 0 ? 2 : 1;
            num >>= 1;
        }
        
        return res;
    }
}