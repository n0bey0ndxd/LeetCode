class Solution {
    Map<Integer, Integer> hs = new HashMap<>();

    public int fib(int n) {
        if (n < 2){
            return n;
        }
        
        int res;
        
        if (hs.containsKey(n)){
            res = hs.get(n);
        }
        else{
            res = fib(n - 1) + fib(n - 2);
            
            hs.put(n, res);
        }
        
        return res;
    }
}