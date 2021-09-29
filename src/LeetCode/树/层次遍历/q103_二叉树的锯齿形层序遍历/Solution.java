package LeetCode.树.层次遍历.q103_二叉树的锯齿形层序遍历;

import java.util.*;

/**
 * @ClassName q103_二叉树的锯齿形层序遍历
 * @Author audience
 * @Date 2021/9/2
 * @Version 1.0
 * @Description
 * 思路：与q102_二叉树的层序遍历类似，额外的需要定义一个boolean类变量
 *      来标识是奇数行还是偶数行
 *      root是第0层、偶数，从左到右
 *      root下一层是1层，奇数，从右到做 以此类推
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> lists = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        //定义flag来标识奇偶层
        boolean flag = true;
        while (!queue.isEmpty()){
            //双向队列，支持元素从前后两端插入和移除
            Deque<Integer> deque = new LinkedList<>();
            int size = queue.size();
            while (size>0){
                TreeNode node = queue.poll();
                //判断奇偶
                if (flag){
                    //尾插，正序
                    deque.addLast(node.val);
                }else {
                    //头插，逆序
                    deque.addFirst(node.val);
                }
                if (node.left!=null){
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
                size--;
            }
            //加到要返回集合中
            lists.add(new LinkedList<>(deque));
            //一层遍历结束，遍历下一层，改变奇偶性
            //不能直接赋值false，因此下一次的下一次遍历，为偶数，但是不能赋值为true
            flag = !flag;
        }
        return lists;
    }
}
