package 树.q111_二叉树的最小深度;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/8/4
 * @Version 1.0
 * @Description
 */
public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        //如果没有左或右子树，那么无需比较最小值，直接返回其中一个路径
        if (left ==0 || right ==0){
            return left+right+1;
        }
        //左右都有子树，取最小的那个
        return Math.min(left,right)+1;
    }
}
