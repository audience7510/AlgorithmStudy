package LeetCode.树.递归.q437_路径总和III;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/8/3
 * @Version 1.0
 * @Description
 * 思路：先前序遍历每个节点，然后再以每个节点为起始节点，递归寻找满足条件的路径
 */
public class Solution {
    int pathNumber = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null){
            return 0;
        }
        //当前节点root为起始节点
        sum(root,targetSum);
        //递归左右节点
        pathSum(root.left,targetSum);
        pathSum(root.right,targetSum);
        return pathNumber;
    }
    /**
     * 当前节点root为起始节点，找到符合条件的节点，并且与
     * @see LeetCode.树.q112_路径总和.Solution 题目类似，做减法
     */
    public void sum(TreeNode root,int sum){
        if (root == null){
            return;
        }
        //sum减去当前节点的值
        sum = sum - root.val;
        //等于0说明符合条件
        if (sum == 0){
            pathNumber++;
        }
        //递归当前节点的左右节点
        sum(root.left,sum);
        sum(root.right,sum);
    }
}
