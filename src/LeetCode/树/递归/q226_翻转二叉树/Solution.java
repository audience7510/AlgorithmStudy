package LeetCode.树.递归.q226_翻转二叉树;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/8/3
 * @Version 1.0
 * @Description
 * 思路：暂存left，right赋值给left，left赋值给right
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }
        //因为是先将right赋值给left，因此先将left的暂存一下，保证是老的left
        TreeNode left = root.left;
        //将right赋值给left
        root.left = invertTree(root.right);
        //将暂存下来的left，赋值给right
        root.right = invertTree(left);
        return root;
    }

    public TreeNode invertTree2(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        invertTree2(root.left);
        invertTree2(root.right);
        return root;
    }
}
