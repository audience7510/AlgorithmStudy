package 树.q94_二叉树的中序遍历;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/7/12
 * @Version 1.0
 * @Description
 * 二叉树q96中序遍历、q144二叉树前序遍历、q145二叉树后序遍历
 */
public class Solution {
    /**
     * @Date 2021/7/12
     * @Param [root]
     * @return java.util.List<java.lang.Integer>
     * @Description 递归写法
     */
    public List<Integer> orderRecursion(TreeNode root) {
        //前序遍历
        orderRecursion(root.left);
        //中序遍历
        orderRecursion(root.right);
        //后序遍历
        return null;
    }

    /**
     * @Date 2021/7/12
     * @Param [root]
     * @return java.util.List<java.lang.Integer>
     * @Description 前序遍历 迭代写法
     */
    public List<Integer> preOrderIteration(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null){
                continue;
            }
            ret.add(node.val);
            // 先右后左，保证左子树先遍历
            stack.push(node.right);
            stack.push(node.left);
        }
        return ret;
    }

    /**
     * @Date 2021/7/12
     * @Param [root]
     * @return java.util.List<java.lang.Integer>
     * @Description 后序遍历 迭代写法
     */
    public List<Integer> postOrderIteration(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null){
                continue;
            }
            ret.add(node.val);
            stack.push(node.left);
            stack.push(node.right);
        }
        Collections.reverse(ret);
        return ret;
    }

    /**
     * @Date 2021/7/12
     * @Param [root]
     * @return java.util.List<java.lang.Integer>
     * @Description 中序遍历 迭代写法
     */
    public List<Integer> inOrderIteration(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null){
            return ret;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            ret.add(node.val);
            cur = node.right;
        }
        return ret;
    }
}
