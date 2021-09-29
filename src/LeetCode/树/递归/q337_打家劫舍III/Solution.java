package LeetCode.树.递归.q337_打家劫舍III;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/8/5
 * @Version 1.0
 * @Description
 * 思路：树的间隔遍历，对于root来说，偷root，则不能偷root.left和root.right
 *      只能偷root.left和root.right 的子节点，即孙子节点
 *      如果不偷root，则偷root.left和root.right
 */
public class Solution {
    Map<TreeNode,Integer> map = new HashMap<>();
    public int rob(TreeNode root) {
        if (root == null){
            return 0;
        }
        if (map.containsKey(root)){
            return map.get(root);
        }
        //抢root节点
        //root的值
        int val1 = root.val;
        //root.left的子节点：root.left.left和root.left.right
        int val2 = root.left==null? 0 : (rob(root.left.left)+rob(root.left.right));
        //root.right的子节点：root.right.left和root.right.right
        int val3 = root.right==null? 0:(rob(root.right.left)+rob(root.right.right));
        int sum1 = val1+val2+val3;

        //不抢root节点，则抢root.left和root.right
        int sum2 = rob(root.left)+rob(root.right);
        //两种情况取最大值
        int sum = Math.max(sum1,sum2);
        //记录最大值
        map.put(root,sum);
        return sum;
    }
}
