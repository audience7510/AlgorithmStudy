package LeetCode.树.BST.q98_验证二叉搜索树;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/10/18
 * @Version 1.0
 * @Description
 * 思路：递归和迭代，判断root节点和左右节点值的大小
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return validBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    private boolean validBST(TreeNode root, long minValue, long maxValue) {
        if (root == null){
            return true;
        }
        if (root.val<=minValue || root.val>= maxValue){
            return false;
        }
        return validBST(root.left,minValue,root.val)&&validBST(root.right,root.val,maxValue);
    }
}
