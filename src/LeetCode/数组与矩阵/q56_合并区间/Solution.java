package LeetCode.数组与矩阵.q56_合并区间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/9/27
 * @Version 1.0
 * @Description
 * 思路：对二维数组的的 左端点 升序排序，创建一个集合用于存储intervals遍历出来的数组
 *      当集合的最后一个数组的右端点，小于intervals遍历出来数组的左端点，不重合
 *      那么就加到集合中，否则重合，更新集合的最后一个数组的右端点为 当前遍历出来的右端点
 */
public class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null){
            //[[0,0]]
            return new int[0][2];
        }
        //根据数组的左端点升序排序
//        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            //左端点
            int l = intervals[i][0];
            //右端点
            int r = intervals[i][1];

            //数组中的最后一位的右端点
            //如果小于intervals遍历出来的左端点，说明不重合
            if (list.size() == 0|| list.get(list.size()-1)[1] < l){
                //不重合就把intervals遍历出来的放入集合
                list.add(intervals[i]);
            }else {
                //如果重合，更新 数组中的最后一位的右端点
                list.get(list.size()-1)[1] = Math.max(list.get(list.size()-1)[1],r);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
