package LeetCode.搜索.回溯.q39_组合总和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/10/19
 * @Version 1.0
 * @Description
 * 思路：使用回溯的模板
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates,target,res,new ArrayList<>(),0);
        return res;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> res, List<Integer> list,int index) {
        if (target < 0){
            return;
        }
        if (target == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        //遍历数组
        for (int i = index; i < candidates.length; i++) {
            //如果target<0不满足条件跳出循环
            if (target<0){
                break;
            }
            //放入集合
            list.add(candidates[i]);
            //递归调用，参数i为当前元素的索引，下次target大于0，还会将当前元素放入集合
            dfs(candidates,target-candidates[i],res,list,i);
            //撤销选择
            list.remove(list.size()-1);
        }

    }
}
