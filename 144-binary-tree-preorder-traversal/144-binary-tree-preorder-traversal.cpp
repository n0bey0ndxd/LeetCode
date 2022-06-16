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
    vector<int> preorderTraversal(TreeNode* root) {
       if (!root) {
            return {};
        }
        
        std::vector<int> res;

        std::stack<TreeNode*> s;
        s.push(root);

        TreeNode* node = s.top();

        while (!s.empty()) {
            TreeNode* node = s.top();
            res.push_back(node->val);
            s.pop();

            if (node->right) {
                s.push(node->right);
            }

            while (node->left) {
                TreeNode* r = node->left->right;
                if (r) {
                    s.push(r);
                }
                res.push_back(node->left->val);

                node = node->left;
            }
        }

        return res;
    }
};