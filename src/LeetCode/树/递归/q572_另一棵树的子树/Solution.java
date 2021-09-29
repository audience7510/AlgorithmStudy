package LeetCode.树.递归.q572_另一棵树的子树;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/8/4
 * @Version 1.0
 * @Description
 * 思路：A树是B树的子树，要么A、B树相等，要么A是B的左或者右子树
 */
public class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null){
            return false;
        }
        //判断两棵树是否相等
        boolean subtreeWithRoot = isSubtreeWithRoot(root, subRoot);
        //判断是否是左、右子树
        boolean left = isSubtree(root.left, subRoot);
        boolean right = isSubtree(root.right, subRoot);
        //三种情况有一种成立，说明subRoot是root的子树
        return subtreeWithRoot || left || right;
    }

    /**
     * 通过给定root，判断root和subRoot是否相等
     */
    public boolean isSubtreeWithRoot(TreeNode root,TreeNode subRoot){
        if (root == null && subRoot == null){
            return true;
        }
        if (root == null || subRoot == null){
            return false;
        }
        if (root.val != subRoot.val){
            return false;
        }
        //判断root的左子树与subRoot的左子树是否相等
        boolean left = isSubtreeWithRoot(root.left, subRoot.left);
        //判断root的右子树与subRoot的右子树是否相等
        boolean right = isSubtreeWithRoot(root.right, subRoot.right);
        //当左右都相等时，两棵树才相等
        return left&&right;
    }
}
