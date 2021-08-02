package 树.q110_平衡二叉树;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/7/12
 * @Version 1.0
 * @Description
 * 思路：平衡树左右子树高度差都小于等于 1
 */
public class Solution {
    private boolean result = true;
    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return result;
    }

    public int maxDepth(TreeNode root){
        if (root == null){
            return 0;
        }
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        //左树右树的高度差大于1
        if (Math.abs(l-r) > 1){
            result = false;
        }
        return 1 + Math.max(l,r);
    }
}
