package LeetCode.树.递归.q113_路径总和II;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/10/8
 * @Version 1.0
 * @Description
 * 思路：该题目解题思路与
 * @see LeetCode.树.递归.q112_路径总和.Solution 解题思路一样，
 * 并使用了一个双向队列 Deque 存储路径的节点值
 * 回溯，双向队列加入root节点的值，递归之后再移除
 */
public class Solution {

    List<List<Integer>> lists = new ArrayList<>();
    //不使用Queue原因：单向队列，一端进，另一端出，返回集合中 节点值的顺序是从根节点到子节点，
    //queue先进先出，会把先把根节点移除，所以不使用
    //Dueue双向队列，两端可以操作，后进先出，类似于栈，用于存储满足条件的节点值
    Deque<Integer> path = new LinkedList();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root,targetSum);
        return lists;
    }

    private void dfs(TreeNode root, int targetSum) {
        if (root == null){
            return;
        }
        //添加到末尾
        path.offerLast(root.val);
        targetSum = targetSum -root.val;
        if (root.left == null && root.right == null && targetSum == 0){
            lists.add(new LinkedList<>(path));
        }
        dfs(root.left,targetSum);
        dfs(root.right,targetSum);
        //移除末尾元素
        path.pollLast();
    }
}
