package 树.递归.q236_二叉树的最近公共祖先;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/9/2
 * @Version 1.0
 * @Description
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return root;
        }
        if (root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null){
            return right;
        }
        if (right == null){
            return left;
        }
        return root;
    }
}
