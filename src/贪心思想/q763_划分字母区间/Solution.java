package 贪心思想.q763_划分字母区间;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/7/15
 * @Version 1.0
 * @Description
 * 思路：思路：将字符串分成多个片段就是要在字符串中找出断点，断点是某个字符最后出现的位置，
 *      那么统计每个字符出现的最后一个位置，
 *      使用start记录子串开始位置初始为0，end记录子串结束为止，
 *      遍历字符查找字符最后出现的位置作为end，
 *      当i==等于end时i之前的所有字符都在该片段中，
 *      i就是断点，计算子串长度end-start+1，start变为i+1
 */
public class Solution {
    public List<Integer> partitionLabels(String s) {
        //存放字符出现的最后一个位置
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            //数组的索引为字符与'a'相减的值，值为出现的位置
            //当遍历结束，索引对应的值就是字符出现的最后一个位置
            last[char2Index(s.charAt(i))] = i;
        }
        List<Integer> list = new ArrayList<>();
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            //得到字符，并取出最后的位置的值
            int lastIndex = last[char2Index(s.charAt(i))];
            //将最后位置的值赋给end
            end = Math.max(end,lastIndex);
            //如果end与i相等，那么说明已经遍历到了字符最后一个位置
            if (end == i){
                //做差得到长度
                list.add(end - start +1);
                //然后将start的位置改为上一个字符最后位置加1
                start = end + 1;
            }
        }
        return list;
    }

    public int char2Index(char c) {
        return c - 'a';
    }
}
