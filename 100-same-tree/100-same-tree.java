class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> q_p = new ArrayDeque<>();
        Queue<TreeNode> q_q = new ArrayDeque<>();

        if (p == null || q == null){
            return p == q;
        }

        q_p.add(p);
        q_q.add(q);

        while(!q_p.isEmpty() && !q_q.isEmpty()){
            TreeNode q_node = q_q.poll();
            TreeNode p_node = q_p.poll();

            if (q_node != null && p_node != null){
                if (q_node.val != p_node.val){
                    return false;
                }

                if (p_node.left != null && q_node.left != null){
                    q_p.add(p_node.left);
                    q_q.add(q_node.left);
                }
                else if (p_node.left != q_node.left){
                    return false;
                }

                if (p_node.right != null && q_node.right != null){
                    q_p.add(p_node.right);
                    q_q.add(q_node.right);
                }
                else if (p_node.right != q_node.right){
                    return false;
                }
            }
            else if (q_node != p_node){
                return false;
            }
        }

        return true;
    }
}