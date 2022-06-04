class Solution {
    public boolean backspaceCompare(String s, String t) {
        char h = '#';

        Stack<Character> stack_s = new Stack<>();
        Stack<Character> stack_t = new Stack<>();

        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if (c == h){
                if (!stack_s.empty()){
                    stack_s.pop();
                }
            }
            else{
                stack_s.push(c);
            }
        }

        for (int i = 0; i < t.length(); i++){
            char c = t.charAt(i);

            if (c == h){
                if (!stack_t.empty()){
                    stack_t.pop();
                }
            }
            else{
                stack_t.push(c);
            }
        }

        return stack_s.equals(stack_t);
    }
}