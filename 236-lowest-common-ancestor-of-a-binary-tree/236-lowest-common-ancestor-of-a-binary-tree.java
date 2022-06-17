/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }

        if (root == p || root == q){
            return root;
        }
        
        TreeNode r_n = lowestCommonAncestor(root.right, p, q);
        TreeNode l_n = lowestCommonAncestor(root.left, p, q);
        
        if (r_n != null && l_n != null){
            return root;
        }
        else if (r_n == null || l_n == null){
            return r_n != null ? r_n : l_n;
        }
        
        return null;
    }
}