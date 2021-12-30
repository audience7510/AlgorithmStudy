package LeetCode.搜索.回溯.q78_子集;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/9/28
 * @Version 1.0
 * @Description
 * 思路：创建二维数组res，用于存储子集(一维数组)
 *      遍历nums，在nums的for循环中遍历res，得到res中的每一个子集，并赋值给新子集
 *      新子集中放入nums中的值，并添加到res中
 *      关键在于遍历res之后，得到集合赋值给新集合
 *
 *      时间复杂度O(n * 2^N)，空间复杂度O(n)
 *      一共有2的n次方中结果集，每个结果集需要O(n)的时间复杂度来构建
 *      temp集合的空间复杂度O(n)
 */
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        //遍历nums
        for (int i = 0; i < nums.length; i++) {
            //nums本次循环拿到res的size
            int resSize = res.size();
            for (int j = 0; j < resSize; j++) {
                //拿到res中的子集，赋值给一个新的子集
                List<Integer> temp = new ArrayList<>(res.get(j));
                //往新子集中加入nums本次遍历的值
                temp.add(nums[i]);
                //往res放入新子集
                res.add(temp);
            }
        }
        return res;
    }
}
