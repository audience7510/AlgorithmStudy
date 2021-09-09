package 字符串.q5_最长回文子串;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/9/7
 * @Version 1.0
 * @Description
 * 思路：动态规划时间复杂度O(n2)，空间复杂度O(n2)
 *      中心扩展法，时间复杂度O(n2)，空间复杂度O(1)。从回文中心向两端扩展，
 *      直到无法扩展为止
 */
public class Solution {
    public static String longestPalindrome(String s) {
        if (s == null || s.length()<1){
            return "";
        }
        int start = 0;
        int end = 0;
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            //奇数 以i为回文中心，最长字符串
            String s1 = expandAroundCenter(s,i,i);
            //偶数 以i和i+1为回文中心，最长字符串
            String s2 = expandAroundCenter(s,i,i+1);
            res = res.length()>s1.length()?res:s1;
            res = res.length()>s2.length()?res:s2;
        }
        return res;
    }

    public static String expandAroundCenter(String s, int left, int right) {
        //索引在0和length之间，并且回文中心 两边相等，说明是回文串
        while (left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
            //向左和向右移动
            left--;
            right++;
        }
        //最终返回回文字符串长度vadcdam 0+1=1 6-0-1=5
        return s.substring(left+1,right-left-1);
    }

    public static void main(String[] args) {
        String babad = longestPalindrome("babad");
        System.out.println(babad);
    }
}
