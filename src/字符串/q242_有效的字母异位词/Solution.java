package 字符串.q242_有效的字母异位词;

import java.util.Map;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/8/17
 * @Version 1.0
 * @Description
 * 思路：可以使用HashMap来映射字符与出现的次数，key为字符，value为次数，然后比较两个字符串出现的次数是否相等
 *      q242中，只包含26个小写字母，则可以用长度为26的数组对出现的字符串进行统计
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
            //出现次数相加
            arr[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            //出现次数相减
            arr[c - 'a']--;
        }
        for (int i : arr) {
            //两个字符串出现字符的次数不相等，说明不符合
            if (i != 0){
                return false;
            }
        }
        return true;
    }
}
