package 树.递归.q404_左叶子之和;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/8/4
 * @Version 1.0
 * @Description
 * 思路：如果叶子节点，则说明当前节点的left不为null，并且left的左右都没有节点
 *      定义变量，记录叶子节点的值，递归左右节点
 */
public class Solution {
    int res = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null){
            return 0;
        }
        //判断是否是叶子节点
        if (root.left!=null && root.left.left == null && root.left.right ==null){
            res += root.left.val;
        }
        //root的左侧子树的左子节点
        sumOfLeftLeaves(root.left);
        //root的右侧子树的左子节点
        sumOfLeftLeaves(root.right);
        return res;
    }
}
