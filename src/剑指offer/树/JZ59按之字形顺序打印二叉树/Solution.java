package 剑指offer.树.JZ59按之字形顺序打印二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/9/30
 * @Version 1.0
 * @Description
 */
public class Solution {
    //TODO
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        while (!queue.isEmpty()){
            ArrayList<Integer> arrayList = new ArrayList();
            int size = queue.size();
            while (size>0){
                TreeNode poll = queue.poll();
                arrayList.add(poll.val);

            }
        }

        return null;
    }
}
