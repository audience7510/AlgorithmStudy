package LeetCode.树.层次遍历.q513_找树左下角的值;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/8/5
 * @Version 1.0
 * @Description
 */
public class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            //从队列中取出
            root = queue.poll();
            //把这一层的节点加入到队列中
            if (root.left!=null){
                queue.add(root.left);
            }
            if (root.right!=null){
                queue.add(root.right);
            }
        }

        return root.val;
    }


}
