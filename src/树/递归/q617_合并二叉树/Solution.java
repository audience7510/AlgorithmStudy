package 树.递归.q617_合并二叉树;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/8/3
 * @Version 1.0
 * @Description
 * 思路：创建新节点，并左右节点的值相加，把两个节点的左右节点，赋值给新节点
 */
public class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null&&root2 == null){
            return null;
        }
        if (root1 == null){
            return root2;
        }
        if (root2 == null){
            return root1;
        }
        //创建新的节点，并将两个节点的值相加
        TreeNode treeNode = new TreeNode(root1.val+root2.val);
        //root1和root2的左节点，赋值给新节点的左节点
        treeNode.left = mergeTrees(root1.left, root2.left);
        //右节点同理
        treeNode.right = mergeTrees(root1.right,root2.right);
        return treeNode;
    }
}
