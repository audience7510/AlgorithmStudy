package 剑指offer.树.JZ38二叉树的深度;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/9/29
 * @Version 1.0
 * @Description
 */
public class Solution {
    public int TreeDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        return Math.max(left,right)+1;
    }
}
