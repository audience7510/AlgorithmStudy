package 树.递归.q543_二叉树的直径;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/8/3
 * @Version 1.0
 * @Description
 * 思路：最大直径就是左右子树最大路径和
 */
public class Solution {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }

    public int depth(TreeNode root){
        if (root == null){
            return 0;
        }
        int l = depth(root.left);
        int r = depth(root.right);
        //以该节点为根，取左右子树的路径和的最大值
        max = Math.max(this.max, l + r);
        //以该节点为根的子树的(路径)深度
        return Math.max(l,r)+1;
    }
}
