package LeetCode.数组与矩阵.q128_最长连续序列;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/10/21
 * @Version 1.0
 * @Description
 * 思路：set集合去重，遍历集合，如果不包含当前元素减一的值(说明不是连续序列的中间值)，
 *      while循环当前值加1寻找递增序列
 */
public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        //去重
        for (int num : nums) {
            set.add(num);
        }
        int size = 0;
        //遍历set
        for (Integer integer : set) {
            //非连续序列的中间值
            if (!set.contains(integer-1)){
                //当前值
                int curNum = integer;
                //当前值连续序列的长度
                int curSize = 1;
                //加1找到递增序列
                while (set.contains(curNum+1)){
                    curNum += 1;
                    curSize += 1;
                }

                size = Math.max(size,curSize);
            }
        }
        return size;
    }
}
