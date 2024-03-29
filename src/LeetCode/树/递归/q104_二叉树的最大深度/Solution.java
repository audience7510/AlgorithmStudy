package LeetCode.树.递归.q104_二叉树的最大深度;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/7/30
 * @Version 1.0
 * @Description
 * 思路：递归左右子树并+1
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        //返回以该节点为根的子树的深度
        return Math.max(left,right)+1;
    }
}
