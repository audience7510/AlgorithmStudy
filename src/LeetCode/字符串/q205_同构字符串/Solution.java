package LeetCode.字符串.q205_同构字符串;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/8/18
 * @Version 1.0
 * @Description
 * 思路：记录一个字符上次出现的位置，如果两个字符串中的字符，上次出现的位置一样，那么就满足同构
 */
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] preIndexOfS = new int[256];
        int[] preIndexOfT = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (preIndexOfS[sc]!=preIndexOfT[tc]){
                return false;
            }
            //索引加1
            preIndexOfS[sc] = i+1;
            preIndexOfT[tc] = i+1;
        }
        return true;
    }
}
