package LeetCode.树.层次遍历.q637_二叉树的层平均值;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/8/5
 * @Version 1.0
 * @Description
 * 思路：初始时，将根节点加入到队列，每一轮遍历，将队列中的节点全部取出，
 *      求和并计算平均值，然后将这些节点的全部非空子节点加入到队列，
 *      并重复上述步骤
 */
public class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        //用于存储每一层的平均值
        List<Double> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        //现将root节点放入队列
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            //节点的和
            double sum = 0;
            //遍历取出所有节点，即为这一层的所有节点
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                //值相加
                sum += treeNode.val;
                //左右节点不为null，加入到队列中
                if (treeNode.left!=null){
                    queue.add(treeNode.left);
                }
                if (treeNode.right!=null){
                    queue.add(treeNode.right);
                }
            }
            list.add(sum/size);
        }
        return list;
    }
}
