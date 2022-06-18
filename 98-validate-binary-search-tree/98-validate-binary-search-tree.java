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
    public boolean isValidBST(TreeNode root) {
        return isValidRec(root.left, Long.MIN_VALUE, root.val) && isValidRec(root.right, root.val, Long.MAX_VALUE);
    }

    private boolean isValidRec(TreeNode node, long min, long max){
        if (node == null){
            return true;
        }

        if (node.val <= min){
            return false;
        }

        if (node.val >= max){
            return false;
        }

        return isValidRec(node.left, min, node.val) && isValidRec(node.right, node.val, max);
    }
}