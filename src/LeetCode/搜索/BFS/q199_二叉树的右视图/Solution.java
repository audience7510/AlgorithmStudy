package LeetCode.搜索.BFS.q199_二叉树的右视图;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/9/15
 * @Version 1.0
 * @Description
 * 思路：对树的每一层进行遍历，并记录每一层的最后一个元素
 *      怎么样才是一层遍历？加到queue队列中的node节点，再用一次for循环遍历，
 *
 */
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            for (int i = 0; i < queue.size(); i++) {
                TreeNode node = queue.poll();
                if (node.left!=null){
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
                //当前层的最后一个放入list中，因为最后一个是right
                if (i == queue.size()-1){
                    list.add(node.val);
                }
            }
        }
        return list;
    }
}
