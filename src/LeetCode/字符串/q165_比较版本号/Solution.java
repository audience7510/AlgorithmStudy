package LeetCode.字符串.q165_比较版本号;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/10/22
 * @Version 1.0
 * @Description
 * 二分法：时间复杂度O(m+n)，空间复杂度O(m+n)
 */
public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] m = version1.split("\\.");
        String[] n = version2.split("\\.");
        for (int i = 0; i < m.length || i < n.length; i++) {
            int x = 0;
            int y = 0;
            if (i<m.length){
                x = Integer.parseInt(m[i]);
            }
            if (i<n.length){
                y = Integer.parseInt(n[i]);
            }
            if (x>y){
                return 1;
            }
            if (x<y){
                return -1;
            }
        }
        return 0;
    }
}
