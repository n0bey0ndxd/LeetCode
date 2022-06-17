/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null){
            return null;
        }
        
        Queue<Node> q = new ArrayDeque<>();
        
        Node prev_n = null;
        q.add(root);
        
        while(!q.isEmpty()){
            int cnt = q.size();
            for (int i = 0; i < cnt; i++){
                Node node = q.poll();
                if (prev_n != null){
                    prev_n.next = node;
                }
                
                prev_n = node;
                
                if (node.left != null){
                    q.add(node.left);
                }
                if (node.right != null){
                    q.add(node.right);
                }
                
                if (i + 1 == cnt){
                    prev_n = null;
                }
            }
        }
        
        return root;
    }
}