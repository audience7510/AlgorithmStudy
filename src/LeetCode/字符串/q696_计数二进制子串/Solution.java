package LeetCode.字符串.q696_计数二进制子串;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/8/18
 * @Version 1.0
 * @Description
 * 思路：例如s=00111011这样的字符串，可以看做counts={2,3,1,2}这样的数组
 *      counts中的前两个，若要满足条件，则取2和3中的最小，才能配对。即min{2,3}
 */
public class Solution {
    public int countBinarySubstrings(String s) {
        //当前遍历到的位置
        int cur = 0;
        //满足条件的个数
        int res = 0;
        //上一种字符的个数(例如：遍历1100，遍历到第一个0时，pre的值为2，它记录的是1的个数)
        int pre = 0;
        while (cur<s.length()){
            //拿到当前的字符
            char c = s.charAt(cur);
            //与当前字符相同的个数
            int count = 0;
            //当前字符与下一个字符相等
            while (cur<s.length() && s.charAt(cur) == c){
                //后移一位
                cur++;
                //个数加1
                count++;
            }
            //上一种字符的个数，与当前字符的个数，取最小的一个，因为最小值才能成对
            res += Math.min(pre,count);
            //res值加上之后，将当前个数，赋给pre，再继续循环，就变成上一种字符的个数了
            pre = count;
        }
        return res;
    }
}
