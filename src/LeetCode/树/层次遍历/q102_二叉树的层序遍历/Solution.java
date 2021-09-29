package LeetCode.树.层次遍历.q102_二叉树的层序遍历;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/9/2
 * @Version 1.0
 * @Description
 * 思路：创建一个二维数组(集合)用于返回数据，创建一个Integer类型集合存储该层节点的值
 *      创建一个队列，用于存储并遍历每层的节点
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }

        //队列存储每一层的节点
        Queue<TreeNode> queue = new LinkedList<>();
        //返回数据
        List<List<Integer>> lists = new ArrayList<>();
        //加入首层节点
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            //遍历队列中的节点
            while (size>0){
                //拿到队列中的节点
                TreeNode node = queue.poll();
                //放入集合
                list.add(node.val);
                //将下一层的节点放入队列
                if (node.left!=null){
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
                //该层节点数量减一
                size--;
            }
            //最终返回
            lists.add(list);
        }
        return lists;
    }
}
