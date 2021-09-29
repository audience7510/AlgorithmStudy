package LeetCode.树.递归.q687_最长同值路径;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/8/4
 * @Version 1.0
 * @Description
 * 思路：定义方法path，求单侧最长同值路径
 *      定义变量path，记录最长的路径
 *      递归左右子节点，判断当前节点是否与左右节点值相等
 */
public class Solution {
    int path = 0;
    public int longestUnivaluePath(TreeNode root) {
        path(root);
        return path;
    }

    public int path(TreeNode root){
        if (root == null){
            return 0;
        }
        //当前节点的左子节点为根，单侧最长同值路径
        int left = path(root.left);
        //当前节点的右子节点为根，单侧最长同值路径
        int right = path(root.right);
        //该节点左侧最长同值路径
        int curLeft = 0;
        //该节点右侧最长同值路径
        int curRight = 0;
        if (root.left!=null && root.val == root.left.val){
            //如果节点相同，上次递归的值加1，相当于加上本次的路径1
            //并用当前递归定义的变量记录
            curLeft += left + 1;
        }
        if (root.right!=null && root.val == root.right.val){
            curRight += right + 1;
        }
        //记录最大的路径值
        path = Math.max(path,curLeft+curRight);
        //递归返回当前节点单侧最长同值路径
        return Math.max(curLeft,curRight);
    }
}
