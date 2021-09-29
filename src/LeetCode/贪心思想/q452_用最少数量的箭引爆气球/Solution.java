package LeetCode.贪心思想.q452_用最少数量的箭引爆气球;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/7/15
 * @Version 1.0
 * @Description
 * 思路：题目文字很多，但是思想和q435题目类似，
 *      给定n个闭区间[x,y]，问最少需要确定多少个点，使得每个闭区间中都至少存在一个点
 *      根据一个区间的末尾与另一个区间的开头进行比较，找出不相交的区间
 */
public class Solution {
    public static int findMinArrowShots(int[][] points) {
        //根据end排序
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //使用下面一行相减的情况，过不了用例[[-2147483646,-2147483645],[2147483646,2147483647]]
                //return o1[1] - o2[1];
                return (o1[1] < o2[1]) ? -1 : ((o1[1] == o2[1]) ? 0 : 1);
            }
        });
        int count = 1;
        int end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            //头小于等于上一个区间的末尾，那么是重叠区间
            if (points[i][0] <= end){
                continue;
            }
            //非重叠区间+1
            count++;
            //区间末尾赋值
            end = points[i][1];
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] arr = {{10,16},{2,8},{1,6},{7,12}};
        int minArrowShots = findMinArrowShots(arr);
    }
}
