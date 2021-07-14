package 贪心思想.q435_无重叠区间;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/7/14
 * @Version 1.0
 * @Description
 * 思路：根据区间的end进行排序，找到最小的end，
 *      遍历二维数组，判断遍历出来开始值是否大于end
 *      大于，则说明两个区间不相交
 *      最后用总长度减去不相交的就是相交的区间
 */
public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        //按end的升序进行排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        //至少有一个区间不相交
        int count = 1;
        //排序之后的第一个end是最小的结束区间
        int end = intervals[0][1];
        for (int[] interval : intervals) {
            int start = interval[0];
            //区间开始值大于 上个区间的结束值，那么不相交
            if (start >= end){
                count++;
                //将end值更新
                end = interval[1];
            }
        }
        //遍历结束，找到了所有不相交的区间，总长度减去不相交的，就是要删除的相交区间
        int res = intervals.length - count;
        return res;
    }
}
