class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<String> set = new HashSet<>();

        int max_val = (int) Math.pow(2.0, k);
        

        for (int i = 0, j = k; j <= s.length(); i++, j++){
            String temp = s.substring(i, j);

            set.add(temp);
        }

        return set.size() == max_val;
    }
}