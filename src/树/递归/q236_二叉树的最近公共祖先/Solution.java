package 树.递归.q236_二叉树的最近公共祖先;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/9/2
 * @Version 1.0
 * @Description
 * 思路来源labuladong，后续遍历三种情况
 *      1、如果p和q都在以root为根的树中，root即是p和q的最近公共祖先节点
 *      原因：后续遍历，树从下往上遍历，p、q往上第一次相交就是root，所以就是最近公共祖先
 *      2、那如果p和q都不在以root为根的树中，返回null
 *      3、p和q只有一个存在于root为根的树中，则返回该节点
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //root为null，返回null
        if (root == null){
            return root;
        }
        //p或者q其中一个是root节点，那么该节点就是最近公共祖先，返回该节点，即root
        if (root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //如果p和q都在以root为根的树中，函数返回的即使p和q的最近公共祖先节点
        if(left!=null && right!=null){
            return root;
        }
        //那如果p和q都不在以root为根的树中怎么办呢？函数返回null
        if (left == null && right == null){
            return null;
        }
        //p和q只有一个存在于root为根的树中，则返回该节点
        return left == null? right:left;
    }
}
