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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null){
            return false;
        }

        boolean flag = false;

        if (root.right != null || root.left != null){
            if (root.left != null){
                flag = hasPathSum(root.left, targetSum - root.val);
            }

            if (root.right != null && !flag){
                flag = hasPathSum(root.right, targetSum - root.val);
            }

            return flag;
        }

        if (root.val - targetSum == 0){
            return true;
        }

        return false;
    }
}