package LeetCode.字符串.q151_翻转字符串里的单词;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/10/15
 * @Version 1.0
 * @Description
 * String方法
 */
public class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] split = s.split(" ");
        for (int i = split.length-1; i >=0; i--) {
            if (split[i].length()>0){
                sb.append(split[i]).append(" ");
            }
        }
        return sb.toString().trim();
    }
}
