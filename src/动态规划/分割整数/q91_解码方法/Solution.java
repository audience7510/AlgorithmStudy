package 动态规划.分割整数.q91_解码方法;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/7/22
 * @Version 1.0
 * @Description
 * 思路：给定字符串s，使用一个字符，只要s[i]!=0，那么就可以被解码成 A 到 I 中的某个字母
 *      即前i-1字符的解码方式，状态转移方程 fi = f(i-1)
 *      使用两个字符，即s[i-1]和s[i]进行编码，s[i-1]不能等于0，
 *      并且，二者组成的整数小于等于26，就可以被解码成 J 到 Z中的某个字母
 *      即前i-2字符的解码方式，状态转移方程fi = f(i-2)
 *
 */
public class Solution {
    public int numDecodings(String s) {
        //存储解码的方式个数
        int[] arr = new int[s.length()+1];
        //空字符串有一种解码方式
        arr[0] = 1;
        for (int i = 1; i <=s.length(); i++) {
            //不为0 A到I
            if (s.charAt(i-1)!= '0'){
                arr[i] += arr[i-1];
            }
            //J 到 Z
            if (i>1 && s.charAt(i-2)!='0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)){
                arr[i] += arr[i-2];
            }
        }
        return arr[s.length()];
    }
}
