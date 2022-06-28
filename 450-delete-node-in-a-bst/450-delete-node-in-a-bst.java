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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null){
            return null;
        }

        if (root.val < key){
            root.right = deleteNode(root.right, key);
        }
        else if (root.val > key){
            root.left = deleteNode(root.left, key);
        }
        else{
            if (root.left == null || root.right == null){
                return root.left == null ? root.right : root.left;
            }
            
            TreeNode node = root.left;
            while(node.right != null){
                node = node.right;
            }

            root.val = node.val;
            root.left = deleteNode(root.left, root.val);
        }
        
        return root;
    }
}