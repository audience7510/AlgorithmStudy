package 贪心思想.q392_判断子序列;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/7/15
 * @Version 1.0
 * @Description
 * 思路：初始化两个指针i和j，分别指向s和t的初始位置，遍历进行匹配，匹配成功
 *      那么i和j同时后移，匹配失败，j后移，i不变，尝试用t的下一个字符串来匹配
 */
public class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        while (i<s.length() && j<t.length()){
            //判断改索引位置的字符是否相等
            if (s.charAt(i) == t.charAt(j)){
                //相等i后移一位
                i++;
            }
            //不管相不相等，匹配完本次之后，让j后移，再从t中来匹配
            j++;
        }
        //如果i和s的长度相等，那么说明全部匹配上了
        return i == s.length();
    }
}
