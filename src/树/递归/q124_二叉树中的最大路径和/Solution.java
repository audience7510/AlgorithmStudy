package 树.递归.q124_二叉树中的最大路径和;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/9/18
 * @Version 1.0
 * @Description
 * 思路：递归，当前节点的值 与 左右节点贡献值之和，
 *      贡献值是节点值与左或右节点最大值的和
 */
public class Solution {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return max;
    }

    private int maxSum(TreeNode root) {
        if (root == null){
            return 0;
        }
        //递归取左或右节点的贡献值
        int left = Math.max(maxSum(root.left),0);
        int right = Math.max(maxSum(root.right),0);
        //最大路径 取决于该节点值，和左右节点的贡献值
        int curMax = root.val+left+right;
        //更新最大值
        max = Math.max(max,curMax);
        //贡献值  该节点值，加上左或右节点的最大值
        return root.val + Math.max(left,right);
    }
}
