package 字符串.q647_回文子串;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/8/18
 * @Version 1.0
 * @Description
 * 思路：类似双指针思想，遍历字符串到位置i，如果i左边和右边的字符串相等，
 *      那么指针向左和向右移动
 */
public class Solution {
    public int count = 0;
    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            //奇数长度
            setCount(s,i,i);
            //偶数长度
            setCount(s,i,i+1);
        }
        return count;
    }

    public void setCount(String s,int start,int end) {
        //左右指针在0和s.length()之间，并且字符相等
        while (start>=0&&end<s.length() && s.charAt(start) == s.charAt(end)){
            //左右指针移动
            start--;
            end++;
            //回文个数加1
            count++;
        }
    }
}
