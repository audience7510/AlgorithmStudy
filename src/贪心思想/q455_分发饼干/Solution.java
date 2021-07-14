package 贪心思想.q455_分发饼干;

import java.util.Arrays;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/7/14
 * @Version 1.0
 * @Description
 * 思路：先将两个数组排序，排序之后遍历，如果g[gi]<s[si]，说明满足条件
 *      不考虑数组s中s[si]相加的情况
 */
public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gi = 0;
        int si = 0;
        while (gi<g.length&&si<s.length){
            if (g[gi]<s[si]){
                //满足条件索引后移
                gi++;
            }
            //使用过之后索引后移
            si++;
        }
        return gi;
    }
}
