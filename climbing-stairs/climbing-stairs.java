class Solution {
    Map<Integer, Integer> hs = new HashMap<>();
    
    public int climbStairs(int n) {
        if (n < 3){
            return n; 
        }
        
        int result;
        
        if (hs.containsKey(n)){
            result = hs.get(n);
        }
        else{
            result = climbStairs(n - 1) + climbStairs(n - 2);
            hs.put(n, result);
        }
        
        return result;
    }
}