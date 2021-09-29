package LeetCode.数组与矩阵.q46_全排列;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/9/6
 * @Version 1.0
 * @Description
 * 思路来源：labuladong，回溯法，时间复杂度要大于O(n!)，n!为n的阶乘，contains方法时间复杂度为O(n)
 *         1、路径，也就是已经做出的选择。
 *         2、选择列表，也就是你当前可以做的选择。
 *         3、结束条件，也就是到达决策树底层，无法再做选择的条件。
 *         路径使用LinkedList保存，选择列表是nums，结束条件是nums中的元素全在linkedList中
 *
 */
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //记录路径
        LinkedList<Integer> linkedList = new LinkedList<>();
        backtrack(nums,linkedList,res);
        return res;
    }

    // 路径：记录在 linkedList 中
    // 选择列表：nums 中不存在于 linkedList 的那些元素
    // 结束条件：nums 中的元素全都在 linkedList 中出现
    private void backtrack(int[] nums, LinkedList<Integer> linkedList,List<List<Integer>> res) {
        //结束条件
        if (linkedList.size() == nums.length){
            res.add(new LinkedList<>(linkedList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //排除已存在的值
            if (linkedList.contains(nums[i])){
                continue;
            }
            //做选择
            linkedList.add(nums[i]);
            //进入下一层决策树
            backtrack(nums,linkedList,res);
            //取消选择，相当于将该选择再次加入到选择列表
            linkedList.removeLast();
        }
    }

}
