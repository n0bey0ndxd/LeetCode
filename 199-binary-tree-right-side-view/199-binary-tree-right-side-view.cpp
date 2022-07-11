/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    vector<int> rightSideView(TreeNode* root) {
        if (root == nullptr) {
            return {};
        }
        
        std::queue<TreeNode*> q_level, q_next;
        q_level.push(root);
        std::vector<int> res;
        
        while(!q_level.empty() || !q_next.empty()) {
            TreeNode* node = q_level.front();
            q_level.pop();
            
            if (node->left) {
                q_next.push(node->left);
            }
            if (node->right) {
                q_next.push(node->right);
            }
            
            if (q_level.empty()) {
                q_level = std::move(q_next);
                res.push_back(node->val);
            }
        }
        
        return res;
    }
};