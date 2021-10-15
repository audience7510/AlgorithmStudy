package LeetCode.树.递归.q105_从前序与中序遍历序列构造二叉树;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/10/15
 * @Version 1.0
 * @Description
 * 思路：1、先找到根节点。前序遍历，数组索引0为根节点，中序遍历的数组放到map中，
 *      key为节点值，value为节点索引，根据前序遍历的根节点值，拿到中序遍历的根节点索引位置
 *      2、构建根节点
 *      3、中序遍历的root索引，减去左节点索引，为左节点个数，size_left_subtree
 *      4、递归构造左子树
 *      5、前序遍历中「从 左边界+1 开始的 到 左边界 + size_left_subtree」个元素就对应了
 *         中序遍历中「从 左边界 开始到 根节点定位-1」的元素
 *      6、递归构造右子树
 *      7、前序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了
 *         中序遍历中「从 根节点定位+1 到 右边界」的元素
 *
 */
public class Solution {
    private Map<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位中序遍历的根节点
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }

        // 前序遍历中的第一个节点就是根节点
        int preorder_root = preorder_left;
        // 在中序遍历中定位根节点
        int inorder_root = indexMap.get(preorder[preorder_root]);

        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorder_root]);
        // 得到左子树中的节点数目
        int size_left_subtree = inorder_root - inorder_left;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
        return root;
    }
}
