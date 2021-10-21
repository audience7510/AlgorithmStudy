package LeetCode.数组与矩阵.q128_最长连续序列;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/10/21
 * @Version 1.0
 * @Description
 */
public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int size = 0;
        for (Integer integer : set) {
            if (!set.contains(integer-1)){
                int curNum = integer;
                int curSize = 1;
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
