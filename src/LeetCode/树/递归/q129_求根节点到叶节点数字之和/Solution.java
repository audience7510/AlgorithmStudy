package LeetCode.树.递归.q129_求根节点到叶节点数字之和;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/10/15
 * @Version 1.0
 * @Description
 * 思路：深度优先，从根节点开始，若遇到叶子节点，则相加返回，否则对节点进行递归
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root,0);
    }

    private int dfs(TreeNode root, int i) {
        if (root == null){
            return 0;
        }
        int sum = i * 10 + root.val;
        if (root.left!=null && root.right!=null){
            return sum;
        }else {
            return dfs(root.left,sum)+dfs(root.right,sum);
        }
    }
}
