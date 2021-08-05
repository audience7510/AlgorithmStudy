package 树.q671_二叉树中第二小的节点;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/8/5
 * @Version 1.0
 * @Description
 * 思路：如果当前节点和父节点的值不等，那么当前节点就是第二小的节点，
 *      剩下的节点就不用管了，直接返回节点值
 *      如果当前节点和父节点的值相等，递归左右节点
 */
public class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        int i = find(root, root.val);
        return i;
    }

    public int find(TreeNode root,int val){
        if (root == null){
            return -1;
        }
        //如果当前值不等于根节点的值
        if (root.val != val){
            return root.val;
        }
        //下面都是 当前值与根节点值相等 的情况
        //要么有左右两个字节点，要么没有子节点，判断一个left就可以了，没有子节点返回-1
        if (root.left == null){
            return -1;
        }
        //递归找最小值
        int leftMin = find(root.left, val);
        int rightMin = find(root.right, val);
        //没有左节点的值，返回右节点的值
        if (leftMin == -1){
            return rightMin;
        }
        if (rightMin == -1){
            return leftMin;
        }
        //都有值取最小
        return Math.min(leftMin,rightMin);
    }
}
