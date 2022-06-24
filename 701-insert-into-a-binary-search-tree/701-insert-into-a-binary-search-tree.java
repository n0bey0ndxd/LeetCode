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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root != null) {
            RecursiveInsertIntoBST(root, val);
        }
            
        return root != null ? root : new TreeNode(val);
    }

    private void RecursiveInsertIntoBST(TreeNode node, int target){
        boolean isLess = node.val > target;

        if (isLess){
            if (node.left == null){
                node.left = new TreeNode(target);
            }
            else{
                RecursiveInsertIntoBST(node.left, target);
            }
        }
        else{
            if (node.right == null){
                node.right = new TreeNode(target);
            }
            else{
                RecursiveInsertIntoBST(node.right, target);
            }
        }
    }
}