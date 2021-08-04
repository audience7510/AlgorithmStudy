package 树.q101_对称二叉树;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/8/4
 * @Version 1.0
 * @Description
 * 思路：当所给根节点为空或者左右子树对称时，说明是对称二叉树
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        boolean symmetric = isSymmetric(root.left, root.right);
        return symmetric;
    }

    /**
     * 校验左右子树是否对称
     */
    public boolean isSymmetric(TreeNode left,TreeNode right){
        //遍历到最后，都为空了，对称
        if (left == null && right == null){
            return true;
        }
        //一个为空，一个不为空，不对称
        if (left == null || right == null){
            return false;
        }
        //值不相等，不对称
        if (left.val != right.val){
            return false;
        }
        //左子树的 左，和右子树的 右，是否相等
        boolean b1 = isSymmetric(left.left, right.right);
        //左子树的 右，和右子树的 左，是否相等
        boolean b2 = isSymmetric(left.right, right.left);
        //二者取并集才是对称
        return b1&&b2;
    }
}
