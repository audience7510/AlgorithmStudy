package LeetCode.字符串.q3_无重复字符的最长子串;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/8/30
 * @Version 1.0
 * @Description
 * 思路：滑动窗口，并使用map来保存出现过的字符，key为字符，value为字符在字符串中的索引
 *      使用set集合的方法2更容易理解，时间复杂度O(n)
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
                //将i左侧窗口更新，取重复字符的的value+1，和当前索引i二者的最大值
                //value+1为不重复的字符，取二者最大值目的是防止窗口左移
                i = Math.max(map.get(s.charAt(j))+1,i);
            }
            //然后取上一次不重复长度，和本次不重复长度的最大值
            res = Math.max(res,j-i+1);
            //将字符加入到map中
            map.put(s.charAt(j),j);
        }
        return res;
    }

    public int lengthOfLongestSubstring2(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int res = 0;
        while (right<s.length()){
            //set中不存在字符
            if (!set.contains(s.charAt(right))){
                //那么左窗口left不变，右窗口right右移
                set.add(s.charAt(right));
                right++;
            }else {
                /**
                 * set中存在字符
                 * 为什么要再一次while循环，因为取的是子串，与当前right位置重复的字符在left和right中间，
                 * 从left到right删除，直到set中没有重复字符，left到right的长度是无重复最长子串
                 *
                 * 左窗口右移，set移除左窗口元素，直到与右窗口的元素不重复
                 */
                while (set.contains(s.charAt(right))){
                    set.remove(s.charAt(left));
                    left++;
                }
            }
            res = Math.max(res,right-left);
        }
        return res;
    }
}
