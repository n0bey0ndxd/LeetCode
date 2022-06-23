class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrackCombine(k, n, 1, new ArrayList<>(), result);

        return result;
    }
    
    private void backtrackCombine(int k, int n, int cnt, 
                                  List<Integer> list, List<List<Integer>> result){
        if (k == 0){
            result.add(list.stream().toList());
            //result.add(new ArrayList<>(list));
            return;
        }

        for (; cnt <= n; cnt++){
            list.add(cnt);
            backtrackCombine(k - 1, n, cnt + 1, list, result);
            list.remove(list.size() - 1);
        }
    }
}