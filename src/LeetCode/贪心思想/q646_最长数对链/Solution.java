package LeetCode.贪心思想.q646_最长数对链;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/7/22
 * @Version 1.0
 * @Description
 * 思路：按照数对第二个数的升序序列遍历所有数对，即按照pairs[1]升序排序
 */
public class Solution {
    public int findLongestChain(int[][] pairs) {
        //按照升序排序
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));
        int cur = Integer.MIN_VALUE;
        int count = 0;
        for (int[] pair : pairs) {
            //如果比第一个数小
            if (cur < pair[0]){
                //将第二个数赋值给cur，下次遍历进行比较
                cur = pair[1];
                count++;
            }
        }
        return count;
    }
}
