class Solution {
    public List<String> generateParenthesis(int n) {
        Stack<Character> str = new Stack<>();
        List<String> list = new ArrayList<>();
        backtrackParenthesis(n * 2, 0, list, str);


        return list;
    }



    private void backtrackParenthesis(int n, int cnt, List<String> list, Stack<Character> str){
        if (n == 0 && cnt == 0){
            StringBuilder s = new StringBuilder();
            for (char c : str){
                s.append(c);
            }
            list.add(s.toString());

            return;
        }

        if (cnt > 0){
            str.add(')');
            backtrackParenthesis(n - 1, cnt - 1, list, str);
            str.pop();
        }

        if (cnt < n){
            str.add('(');
            backtrackParenthesis(n - 1, cnt + 1, list, str);
            str.pop();
        }
    }
}