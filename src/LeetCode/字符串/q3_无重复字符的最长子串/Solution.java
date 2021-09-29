package LeetCode.字符串.q3_无重复字符的最长子串;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/8/30
 * @Version 1.0
 * @Description
 * 思路：滑动窗口，并使用map来保存出现过的字符，key为字符，value为字符在字符串中的索引
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        //i为左侧窗口
        int i = 0;
        Map<Character,Integer> map = new HashMap<>();
        for (int j = 0; j < s.length(); j++) {
            //如果map中出现过该字符
            if (map.containsKey(s.charAt(j))){
                //遇到重复，更新左侧窗口的位置，取当前索引，和之前左侧窗口索引的最大值
                //目的是保证跳过重复区间
                i = Math.max(map.get(s.charAt(j))+1,i);
            }
            //然后取上一次不重复长度，和本次不重复长度的最大值
            res = Math.max(res,j-i+1);
            //将字符加入到map中
            map.put(s.charAt(j),j);
        }
        return res;
    }
}
