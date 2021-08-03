package 树.q112_路径总和;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/8/3
 * @Version 1.0
 * @Description
 * 思路：假设targetSum为5，分别递归左右节点，每次递归，用targetSum减去该节点的值
 *      当该节点不存在子节点时，比较该节点的值是否与targetSum相等
 *      相等则说明节点的和满足条件
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null){
            return false;
        }
        //该节点不存在子节点，比较值是否相等
        if (root.left == null&&root.right == null){
            return targetSum == root.val;
        }
        //递归该节点的左节点，并用targetSum减去该节点的值
        boolean left = hasPathSum(root.left, targetSum - root.val);
        //递归该节点的右节点，并用targetSum减去该节点的值
        boolean right = hasPathSum(root.right, targetSum - root.val);
        //左右节点有一个满足条件就可以
        return left || right;
    }
}
