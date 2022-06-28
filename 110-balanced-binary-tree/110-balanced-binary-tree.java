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
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        
        int dif = Math.abs(dfs(root.left) - dfs(root.right));
        
        if (dif > 1){
            return false;
        }
        
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int dfs(TreeNode node){
        if (node == null){
            return 0;
        }
        
        return Math.max(dfs(node.left) + 1, dfs(node.right) + 1);
    }
}