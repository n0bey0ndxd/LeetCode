/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {

    Stack<TreeNode> s = new Stack<>();
    TreeNode root;

    public BSTIterator(TreeNode root) {
        this.root = root;
        fillStack(root);
    }

    private void fillStack(TreeNode root){
        s.add(root);
        while(root.left != null){
            s.add(root.left);
            root = root.left;
        }
    }

    public int next() {
        TreeNode node = s.pop();
        if (node.right != null){
            fillStack(node.right);
        }
        
        return node.val;
    }

    public boolean hasNext() {
        return !s.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */