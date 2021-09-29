package LeetCode.双指针.q345_反转字符串中的元音字母;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/7/12
 * @Version 1.0
 * @Description
 * 思路：元音字母a, e, i, o, u, A, E, I, O, U
 *      使用双指针，一个指针从头向尾遍历，一个指针从尾到头遍历，
 *      当两个指针都遍历到元音字符时，交换这两个元音字符
 */
public class Solution {
    public String reverseVowels(String s) {
        HashSet<Character> hashSet = new HashSet<>(
                Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        if (s == null){
            return null;
        }
        int i = 0;
        int j = s.length()-1;
        char[] result = new char[s.length()];
        while (i <= j){
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if (!hashSet.contains(ci)){
                result[i++] = ci;
            }else if (!hashSet.contains(cj)){
                result[j--] = cj;
            }else {
                result[i++] = cj;
                result[j--] = ci;
            }
        }
        return new String(result);
    }
}
